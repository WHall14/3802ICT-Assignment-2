package LMS.LMSCode;

import LMS.LMSData.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static LMS.MyLibrary.Library;

public class MemberCode extends UserCode{
    public static void addMember(String email, String password){
        var Data = new MemberData(email, password, Boolean.FALSE, Boolean.FALSE, Collections.emptyList());
        List<MemberData> temp = new ArrayList<>(Library.getMembers());
        temp.add(Data);
        Library = new LibraryData(Library.getTheLibrarians(), Library.getLibCatalog(), temp);
    }

    public static void addMember(MemberData Mem){
        List<MemberData> temp = new ArrayList<>(Library.getMembers());
        temp.add(Mem);
        Library = new LibraryData(Library.getTheLibrarians(), Library.getLibCatalog(), temp);
    }


    public static void borrow(String MemEmail, BookItemData BookItem){ //Requires the Member and the Book they wish to borrow/Similar to a normal Library how it requires member details
        MemberData Mem = null;
        for (var Member : Library.getMembers()){
            if (Member.getEmail().equals(MemEmail)){
                Mem = Member;
                break;
            }
        }
        if (Mem == null){
            return;
        }

        if (Mem.getBlocked().equals(Boolean.TRUE)){
            System.out.println("This User is Blocked");
            return;
        }


        var Books = Library.getLibCatalog().getListOfBooks();
        Integer Index = -1;
        for (var Item : Books){
            if(Item.getTitle().equals(BookItem.getName())){
                Index = Books.indexOf(Item);
            }
        }
        if (Index.equals(-1)){ // Basic Error Checking. E.g. The book isn't in the Catalog
            return;
        }
        System.out.println("Member: " + Mem.getEmail() + " Has successfully borrowed: " + BookItem.getName());
        BookLendingCode.addBookLendData(BookItem, Mem, Index);
    }

}
