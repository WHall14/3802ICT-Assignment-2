package LMS.LMSCode;

import LMS.LMSData.LibrarianData;
import LMS.LMSData.MemberData;

import static LMS.MyLibrary.Library;

public abstract class UserCode {

    public static void Login(String email, String password) {
        for (var Lib : Library.getTheLibrarians()){
            if (Lib.getEmail().equals(email) && Lib.getPassword().equals(password)){
                Library.getTheLibrarians().remove(Lib);
                var newLib = new LibrarianData(email, password, Boolean.TRUE);
                Library.getTheLibrarians().add(newLib);
                System.out.println("Librarian " + email + " is now logged in");
                return;
            }
        }


        for (var Mem : Library.getMembers()){
            if (Mem.getEmail().equals(email) && Mem.getPassword().equals(password)){
                Library.getMembers().remove(Mem);
                var newMem = new MemberData(email, password, Boolean.TRUE, Mem.getBlocked(), Mem.getLentBooks());
                Library.getMembers().add(newMem);
                System.out.println("Member " + email + " is now logged in");
                return;
            }
        }

        System.out.println("Wrong email or password");
    }

    public static void search(String AuthTitle){//since author is a string and title is a string it'll call the same func or could make 1 return an auth and one a bookdata
        var BookList = Library.getLibCatalog().getListOfBooks();
        
        String Output = "";

        for (var Book : BookList){
            var Authors = Book.getAuthorNames();
            for (var Auth : Authors){
                if (Auth.equals(AuthTitle)){
                    System.out.println("Books Completed by Author Found:");
                    Output = Output.concat("Book: " + Book.getTitle() + "\nAuthor: " + Auth + "\n");

                }
            }
            if (Book.getTitle().equals(AuthTitle)){
                System.out.println("Book found:");
                Output = Book.getTitle();
                break;
            }
        }
        System.out.println(Output);
    }


}
