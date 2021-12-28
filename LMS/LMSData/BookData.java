package LMS.LMSData;

import lombok.Value;

import java.util.List;

@Value
public class BookData{ // DONE
    String title;
    String ISBN;
    Integer publicationYear;
    List<String> authorNames;
    //Book Information^

    List<BookItemData> bookItems; // copies of the book
}
