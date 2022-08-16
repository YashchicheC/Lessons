package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import static com.codeborne.selenide.Selenide.$x;

/* автоматически подтягивать либы для впервые использующихся библиотек ALT+ENTER*/
public class KlavogonkiStep {
    private final SelenideElement closeWindowButton = $x ("//input[@value='Закрыть']");
    private final SelenideElement startGameButton = $x("//a[@id='host_start']");
    private final SelenideElement highlightWord = $x("span [@id='typefocus']");
    private final SelenideElement inputField = $x("//input [@id='inputtext']");
    private final SelenideElement afterFocusForDot = $x("//span[@id='afterfocus']");

    @When("Start the game")
    public void startTheGame()
    {
        Configuration.timeout = 600;
        closeWindowButton.click();
        if(startGameButton.isDisplayed()){startGameButton.click();}
        throw new io.cucumber.java.PendingException();

    }

    @And("Waiting for start")
    public void waitingForStart()
    {
        highlightWord.click();
        throw new io.cucumber.java.PendingException();
    }

    @And("Insert highlight word in circle")
    public void playGame()
    {
        while (true)
        {
            String curentWord = highlightWord.getText();
            String dotOrSymbol = afterFocusForDot.getText();
            inputField.sendKeys(curentWord);
            if(dotOrSymbol.equals("."))
            {
                inputField.sendKeys(".");
                break;
            }
            inputField.sendKeys(Keys.SPACE);
        }
        throw new io.cucumber.java.PendingException();
    }

    @Then("Game complete and symbols more than {int}")
    public void endGame(int minValue)
    {
        System.out.println(minValue);
        throw new io.cucumber.java.PendingException();
    }
}
