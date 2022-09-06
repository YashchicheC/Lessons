package Steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.en.Given;

public class BeforeStep {
    @Given("Open site {string}")
    public void openSite(String url)
    {
        Configuration.timeout = 60000;
        Selenide.open((url));
    }
}
