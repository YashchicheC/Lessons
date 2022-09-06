package Steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import java.security.Key;

import static com.codeborne.selenide.Selenide.$x;

public class KlavogonkiStep
{
    private final SelenideElement closeWelcomePopup = $x("//input[@value = 'Закрыть']");
    private final SelenideElement startButton = $x("//a[@id='host_start']");
    private final SelenideElement highlightWord = $x("//span[@id='typefocus']");
    private final SelenideElement inputField = $x("//input[@id='inputtext']");
    private final SelenideElement afterFocus = $x("//span[@id='afterfocus']");

    //<input type="button" class="btn" value="Закрыть" onclick="$('howtoplay').hide();">
    @When("Start the game")
    public void startTheGame()
    {
        Configuration.timeout = 1000;

        if(closeWelcomePopup.isDisplayed())
        {
            closeWelcomePopup.click();
        }

        if(startButton.isDisplayed())
        {
            startButton.click();
        }
    }

    @And("Waiting for start")
    public void waitingForStart()
    {
        highlightWord.click();
    }

    @And("Input highlighted value")
    public void inputHighlightedValue()
    {
        while(true)
        {
            String currentWord = highlightWord.getText();
            String afterFocusSymbol = afterFocus.getText();
            inputField.sendKeys(currentWord);

            if(afterFocusSymbol.equals("."))
            {
                inputField.sendKeys(".");
                break;
            }
            inputField.sendKeys(Keys.SPACE);
        }
    }

    @Then("Game Over with more than {int} symbols")
    public void gameOverWithMoreThanSymbols(int minValue)
    {
        System.out.println(minValue);
    }
}
