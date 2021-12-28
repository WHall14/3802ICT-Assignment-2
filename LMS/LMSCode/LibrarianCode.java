package LMS.LMSCode;

import LMS.LMSData.*;

import java.util.ArrayList;
import java.util.List;

import static LMS.MyLibrary.Library;


public class LibrarianCode extends UserCode{

    public static void addLibrarian(String email, String password){
        var Data = new LibrarianData(email, password, Boolean.FALSE);

        List<LibrarianData> temp = new ArrayList<>(Library.getTheLibrarians());
        temp.add(Data);
        Library = new LibraryData(temp, Library.getLibCatalog(), Library.getMembers());
    }

    public static void addLibrarian(LibrarianData Lib){
        List<LibrarianData> temp = new ArrayList<>(Library.getTheLibrarians());
        temp.add(Lib);
        Library = new LibraryData(temp, Library.getLibCatalog(), Library.getMembers());
    }


    public static void blockMember(String MemEmail){
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
        List<MemberData> temp = new ArrayList<>(Library.getMembers());
        var newMem = new MemberData(Mem.getEmail(), Mem.getPassword(), Mem.getLoggedIn(), Boolean.TRUE, Mem.getLentBooks());
        temp.remove(Mem);
        temp.add(newMem);
        Library = new LibraryData(Library.getTheLibrarians(), Library.getLibCatalog(), temp);
    }

    public static void unblockMember(String MemEmail){
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
        List<MemberData> temp = new ArrayList<>(Library.getMembers());
        var newMem = new MemberData(Mem.getEmail(), Mem.getPassword(), Mem.getLoggedIn(), Boolean.FALSE, Mem.getLentBooks());
        temp.remove(Mem);
        temp.add(newMem);
        Library = new LibraryData(Library.getTheLibrarians(), Library.getLibCatalog(), temp);
    }

    public static void listBooks(String MemEmail){
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


        System.out.println("Books on Loan to " + MemEmail +":");
        for (var lentBooks : Mem.getLentBooks()){
            System.out.println(lentBooks.getTheBook() + ", UniqueId: " + lentBooks.getUniqueBookId());
        }
    }




}
