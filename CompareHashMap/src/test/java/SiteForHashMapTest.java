import com.codeborne.selenide.Selenide;
import org.junit.Test;

public class SiteForHashMapTest extends BaseClass
{
    private final static String URL = "https://hh.ru/resume/0b4285a70002fc406c0039ed1f55414b674a4b?query=программист&source=search&hhtmFrom=resumes_catalog";

    @Test
    public void CheckAttributesHashMap()
    {
        Selenide.open(URL);
    }
}
