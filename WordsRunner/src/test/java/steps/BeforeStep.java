package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;



public class BeforeStep
{
    @Given ("Open the link {string}")
    public void OpenTheLink(String url)
    {
        Configuration.timeout = 60000;
        Selenide.open(url);
        throw new io.cucumber.java.PendingException();
    }

}
