package Steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;

import static com.codeborne.selenide.Selenide.$x;

public class AfterStep
{

    @After
    public void tearDown()
    {
        WebDriverRunner.getWebDriver().quit();
    }
    @io.cucumber.java.AfterStep
    public void makeScreenShot()
    {
        Selenide.screenshot(System.currentTimeMillis() + "step");
    }
}
