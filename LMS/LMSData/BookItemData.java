package LMS.LMSData;

import lombok.Value;

@Value
public class BookItemData{ //A book can have multiple copies, each copy is considered as a book item
    String name; // a book item should know its name
    String UniqueBookId;
    BookLendingData IsLent;
}
