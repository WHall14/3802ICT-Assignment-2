package LMS.LMSCode;

import LMS.LMSData.BookItemData;
import LMS.LMSData.BookData;

import java.util.ArrayList;
import java.util.List;

import static LMS.MyLibrary.Library;

public class BookItemCode{
    public static void addBookItem(BookItemData BookItem){
        for (var book : Library.getLibCatalog().getListOfBooks()){
            if (book.getTitle().equals(BookItem.getName())){
                List<BookItemData> temp = new ArrayList<>(book.getBookItems());
                temp.add(BookItem);
                var newBook = new BookData(book.getTitle(), book.getISBN(), book.getPublicationYear(), book.getAuthorNames(), temp);
                Library.getLibCatalog().getListOfBooks().remove(book);
                Library.getLibCatalog().getListOfBooks().add(newBook);
            }
        }
    }
}
