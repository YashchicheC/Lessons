import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage
{
    private final SelenideElement textBoxInput = $x("//input[@type='text']");

    public MainPage(String url) //------------>делаем конструктор для базовой ссылки
    {
        Selenide.open(url);
    }
//------------>для создания Java doc надо ввести /** и потом нажать Enter
    /**
     * Выполняется поиск на сайте среди статей и нажатие Enter
     * @param searchString поисковая строка
     */
    public void search(String searchString)
    {
            textBoxInput.setValue(searchString);
            textBoxInput.sendKeys(Keys.ENTER);
    }
  /*  public void openWebSite(String url) ////КАК ЛЕГКО БАЗОВО ЗАПУСТИТЬ БРАУЗЕР С ПЕРЕХОДОМ. ВЫЗОВ В AppleTest.class
    {
        Selenide.open(url);
    }*/
}
