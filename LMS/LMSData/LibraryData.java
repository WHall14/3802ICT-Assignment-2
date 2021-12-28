package LMS.LMSData;

import lombok.Value;

import java.util.List;

@Value
public class LibraryData { //Library should be able to change
    List<LibrarianData> TheLibrarians;
    CatalogData LibCatalog;
    List<MemberData> Members;
}
