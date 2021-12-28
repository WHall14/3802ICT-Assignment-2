package LMS;
import LMS.LMSCode.*;
import LMS.LMSData.*;

import java.util.Collections;
import java.util.List;

public class MyLibrary {

	public static LibraryData Library = new LibraryData(Collections.emptyList(), new CatalogData(Collections.emptyList()), Collections.emptyList()); //initialise the library


	public static void main(String[] args) {

		//All Code Files are Helper Classes as they had to have only static methods and the data is in the Library Static which makes sense as we have One Library.


		//REQ1
		System.out.println("REQ1");
		MemberData Will = new MemberData("Will", "Pass", Boolean.FALSE, Boolean.FALSE, Collections.emptyList());
		MemberCode.addMember(Will);
		LibrarianData Sean = new LibrarianData("Sean", "Pass", Boolean.FALSE);
		LibrarianCode.addLibrarian(Sean);
		//You can also add Members and Librarians to The system directly
		MemberCode.addMember("Phil", "Pass");
		LibrarianCode.addLibrarian("Bill", "Pass");
		System.out.println(Library.getMembers());
		System.out.println(Library.getTheLibrarians());


		//REQ2
		System.out.println("\nREQ2");
		UserCode.Login("Will", "Pass");
		UserCode.Login("Sean", "Pass");


		//REQ3
		System.out.println("\nREQ3");
		//Add a book for an example
		BookData ArtofWar = new BookData("The Art of War", "12-12-12", 2013, List.of("Sun Tsu"),
				Collections.emptyList());
		CatalogCode.updateManyCatalog(List.of(ArtofWar));
		var BookItem = new BookItemData("The Art of War", "12-12-12-1", new BookLendingData("The Art of War", "", "12-12-12-1"));
		BookItemCode.addBookItem(BookItem);
		//Borrowing a book should know who needs to borrow and the bookItem they wish to borrow
		MemberCode.borrow("Will", BookItem);


		//REQ4
		System.out.println("\nREQ4");
		LibrarianCode.search("The Art of War");
		MemberCode.search("Sun Tsu");


		//REQ5
		System.out.println("\nREQ5");
		LibrarianCode.blockMember("Will");
		var BookItem2 = new BookItemData("The Art of War", "12-12-12-2", new BookLendingData("The Art of War", "", "12-12-12-2"));
		BookItemCode.addBookItem(BookItem2);
		MemberCode.borrow("Will", BookItem2);
		LibrarianCode.unblockMember("Will");
		MemberCode.borrow("Will", BookItem2);


		//REQ6
		System.out.println("\nREQ6");
		LibrarianCode.listBooks("Will"); //Previously borrowed The Art of War Book


		//REQ7
		System.out.println("\nREQ7");
		var BookItem3 = new BookItemData("The Art of War", "12-12-12-3", new BookLendingData("The Art of War", "", "12-12-12-3"));
		var BookItem4 = new BookItemData("The Art of War", "12-12-12-4", new BookLendingData("The Art of War", "", "12-12-12-4"));
		BookItemCode.addBookItem(BookItem3);
		BookItemCode.addBookItem(BookItem4);
		System.out.println(Library.getLibCatalog().getListOfBooks().get(0).getBookItems());



	}
}
