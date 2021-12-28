package LMS.LMSCode;

import LMS.LMSData.*;

import java.util.ArrayList;

import static LMS.MyLibrary.Library;

public class BookLendingCode{
    public static void addBookLendData(BookItemData Book, MemberData Mem, Integer BookIndex){
        var Lentitem = new BookLendingData(Book.getName(), Mem.getEmail(), Book.getUniqueBookId()); // Create the lentItem
        int memIndex = Library.getMembers().indexOf(Mem);
        var temp = new ArrayList<>(Library.getMembers().get(memIndex).getLentBooks()); // get the members lent books
        temp.add(Lentitem);

        Library.getMembers().remove(Mem); // remove old member
        var newMem = new MemberData(Mem.getEmail(), Mem.getPassword(), Mem.getLoggedIn(), Mem.getBlocked(), temp); //create new member
        Library.getMembers().add(newMem); // add new member

        var bookTemp = new ArrayList<>(Library.getLibCatalog().getListOfBooks().get(BookIndex).getBookItems()); // get the books list of references to bookItems it owns
        bookTemp.add(new BookItemData(Book.getName(), Book.getUniqueBookId(), Lentitem));
        bookTemp.removeIf(item -> item.getUniqueBookId().equals(Book.getUniqueBookId()) && item.getIsLent().getTheMember().equals(""));

        for (var book : Library.getLibCatalog().getListOfBooks()){
            if (book.getTitle().equals(Book.getName())){
                Library.getLibCatalog().getListOfBooks().remove(book);
                Library.getLibCatalog().getListOfBooks().add(new BookData(book.getTitle(), book.getISBN(), book.getPublicationYear(), book.getAuthorNames(), bookTemp));
            }
        }

    }

}
