package wiki;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class WikiTest
{
    private static String URL = "https://ru.wikipedia.org/wiki/Java";

    @Test
    public void findAllHrefs()
    {
        Selenide.open(URL);
        ElementsCollection hrefs = $$x("//div[@id='toc']//a[@href]");
        //ElementsCollection - встроеный в Selenide отрибут,два "//" повторно - это вложенный в первый элемент.
        // То бишь мы находим 55 элементов href в папке div с id='toc'
        List<String> links = new ArrayList<>();
        for (int i = 0; i<hrefs.size();i++)
        {
            links.add(hrefs.get(i).getAttribute("href"));
        }
    }
    @Test
    public void findAllHrefsByForeach()
    {
        Selenide.open(URL);
        ElementsCollection hrefLinks = $$x("//div[@id='toc']//a[@href]");
        List<String> links = new ArrayList<>();
        for (SelenideElement element : hrefLinks)
        {
         links.add(element.getAttribute("href"));
        }
    }
    @Test
    public void findAllHrefsByStream()
    {
        Selenide.open(URL);
        ElementsCollection hrefsForStream = $$x("//div[@id='toc']//a[@href]");
        List<String> links = new ArrayList<>();
        hrefsForStream.stream().forEach(x->links.add(x.getAttribute("href")));

        //открытие всех полученных ссылок с помощью stream api
        links.forEach(Selenide::open);// оно же links.forEach(x->Selenide.open(x));

        //извлечение всех ссылок и открытие последовательно, но при этом в currentURL мы получаем именно ссылку из браузера
        for (int i = 0; i<links.size();i++)
        {
            String listURL = links.get(i);
            Selenide.open(listURL);
            String currentURL = WebDriverRunner.getWebDriver().getCurrentUrl();
            Assert.assertEquals(currentURL, listURL);
        }
        //получение длинны ссылки через stream
        List<Integer>linksLength = hrefsForStream.stream().map(x->x.getAttribute("href").length()).collect(Collectors.toList());
    }
}
