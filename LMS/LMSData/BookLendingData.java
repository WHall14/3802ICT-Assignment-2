package LMS.LMSData;

import lombok.Value;

@Value
public class BookLendingData{ // Should relate to one Book and One User
    String TheBook;
    String TheMember;
    String UniqueBookId;
}
