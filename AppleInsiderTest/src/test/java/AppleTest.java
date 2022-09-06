import com.codeborne.selenide.Configuration;
import org.junit.Test;

public class AppleTest extends BaseTest
{
    private final static String BASE_URL = "https://appleinsider.ru/";
    private final static String SEARCH_STRING = "Чем iPhone 13 отличается от iPhone 12";

    @Test
    public void checkHref()
    {
        MainPage mainPage = new MainPage(BASE_URL);
        // mainPage.openWebSite(BASE_URL);//------------>КАК ЛЕГКО ЗАПУСТИТЬ БРАУЗЕР С ПЕРЕХОДОМ*/
        Configuration.timeout = 60000;
        mainPage.search(SEARCH_STRING);
        int a = 0;
    }
}
