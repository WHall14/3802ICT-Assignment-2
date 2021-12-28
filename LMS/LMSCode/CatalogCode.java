package LMS.LMSCode;

import LMS.LMSData.*;
import java.util.ArrayList;

import static LMS.MyLibrary.Library;


import java.util.List;

public class CatalogCode{

    public static void CatalogCodeIni(List<BookData> Lis){ //Only Maybe needed
        Library = new LibraryData(Library.getTheLibrarians(), new CatalogData(Lis), Library.getMembers());
    }


    public static void updateOneCatalog(BookData Book){
        List<BookData> temp = new ArrayList<>(Library.getLibCatalog().getListOfBooks());
        temp.add(Book);
        Library = new LibraryData(Library.getTheLibrarians(), new CatalogData(temp), Library.getMembers());
    }

    public static void updateManyCatalog(List<BookData> lis){
        List<BookData> temp = new ArrayList<>(Library.getLibCatalog().getListOfBooks());
        temp.addAll(lis);
        Library = new LibraryData(Library.getTheLibrarians(), new CatalogData(temp), Library.getMembers());
    }


}
