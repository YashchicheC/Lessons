import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static com.codeborne.selenide.Selenide.$x;

public class SiteForHashMapTest extends BaseClass
{
    private final static String URLforUkr = "https://jobs.dou.ua/companies/avenga/vacancies/220928/?from=rs";

    @Test
    public void CheckAttributesHashMap()
    {
        ResumePage ResumePageExemplar = new ResumePage(URLforUkr); //создание экземпляра класса
        boolean t = ResumePageExemplar.chtoto(); //как пример, вызов пустого класса из экземпляра
        Map<String, Object> expectedAtributes = new HashMap<>();
        expectedAtributes.put(ResumePage.proverkaGorodaDlyaMap, "Вінниця");
        expectedAtributes.put(ResumePage.proverkaDateDlyaMap, "13 жовтня 2022");
        expectedAtributes.put(ResumePage.proverkaVacansiiDlyaMap, true);

        System.out.println(expectedAtributes.get(ResumePage.proverkaDateDlyaMap));
        Map<String, Object> actualAttributes = ResumePageExemplar.getAttributes();
        Assert.assertEquals(expectedAtributes, actualAttributes);

    }

}
