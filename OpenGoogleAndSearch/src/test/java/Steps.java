import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;

public class Steps
{
    boolean good;
    private final SelenideElement ekFirstLogo = $x("//a[@class='logo logo-ua']");
    private final SelenideElement inputField= $x("//input[@id='ek-search']");
    private final SelenideElement startToLogIn = $x("//span[@jtype='click']");
    private final SelenideElement googleLogo = $x("//button[@class='swal2-close']");
    String textForSearch = "how to control the planet when you sin on the sofa";

    @Given("Open site {string}")
    public void openSite(String url)
    {
        Selenide.open(url);
    }

    @When("We on the site")
    public void weOnTheSite()
    {
        if(ekFirstLogo.isDisplayed())
        {
            inputField.sendKeys(textForSearch);
        }
    }

    @And("Click the button")
    public void clickTheButton()
    {
      /*  Configuration.timeout = 5000;
        inputFieldOnTheSite.sendKeys(Keys.ENTER);*/
        startToLogIn.click();
    }

    @Then("See to the result")
    public void seeToTheResult()
    {
        if(googleLogo.isDisplayed())
        {
            System.out.println("It's alive");
        }
    }


}
