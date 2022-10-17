import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import java.util.HashMap;
import java.util.Map;
import static com.codeborne.selenide.Selenide.$x;

public class ResumePage
{

    private final SelenideElement place = $x("//span[@class = 'place']");
    private final SelenideElement title = $x("//h1[@class='g-h2']");
    private final SelenideElement date = $x("//div[@class='date']");
    String checkCity = "Вінниця";
    String checkVacancy = "Middle AQA Engineer (Java) + Manual Testing";

    ////////////////////////////////////////////////////////////////////////////////////////
    public static String proverkaGorodaDlyaMap = "Город";
    public static String proverkaVacansiiDlyaMap = "Вакансия";
    public static String proverkaDateDlyaMap = "Дата";

    /**
     * создается экземпляр класса ResumePage для его последующего выхова  в SiteForHashMapTest
     */
    public ResumePage(String url)
    {
        Selenide.open(url);
    }

    public Map<String, Object> getAttributes()
    {
        Map<String, Object> attributes = new HashMap<>();
        attributes.put(proverkaGorodaDlyaMap,findCity());
        attributes.put(proverkaVacansiiDlyaMap, findNameOfVacancy());
        attributes.put(proverkaDateDlyaMap, Date());
        return attributes;
    }
    /**
    *тоже самое, что выше, но короче//////////////////////////////////////////////////////////

    public Map<String, Object> getAttributes()
    {
        return new HashMap<>()
        {{
            put(proverkaGorodaDlyaMap,findCity());
            put(proverkaVacansiiDlyaMap, findNameOfVacancy());
            put(proverkaDateDlyaMap, Date());
        }};
    }
     */

    public boolean chtoto()
    {
        return true;
    }

    public String findCity()
    {
        String clearText = place.getText().replaceAll("/[a-z]+/g+",""); // регулярные выражения через https://regex101.com/ очистка всего, кроме букв
        String[] textArray = clearText.split(", ");//в массив можно запихнуть полученный текст по словам, где фильтром для отделения следующего слова будет ", "
        for (int i = 0; i < textArray.length; i++)
        {
           // System.out.print(textArray[i] + "_");
            if( checkCity.equals( textArray[i]))
            {
                System.out.println("We have combination");
                return textArray[i];
            }
        }
        System.out.println("Second method works");
        return ("NO COMBINATION");

    }
    public boolean findNameOfVacancy()
    {
        if (checkVacancy.equals(title.getText()))
        {
            System.out.println("Third method works");
            return true;
        }

        return false;
    }
    public String Date()
    {
       // getDate = Integer.parseInt(date.getText());
        return date.getText();
    }

}
