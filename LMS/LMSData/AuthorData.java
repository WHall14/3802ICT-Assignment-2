package LMS.LMSData;
import java.util.List;
import lombok.Value;

@Value
public class AuthorData{
    String name;
    List<String> BookIsbn;
}
