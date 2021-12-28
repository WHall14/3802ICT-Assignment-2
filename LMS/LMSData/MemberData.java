package LMS.LMSData;

import lombok.Value;

import java.util.List;

@Value
public class MemberData {
    String email;
    String password;
    Boolean LoggedIn; //Flag Toggled by successful login
    Boolean Blocked; //This can only be changed by the Librarian
    List<BookLendingData> LentBooks; //Starts empty
}
