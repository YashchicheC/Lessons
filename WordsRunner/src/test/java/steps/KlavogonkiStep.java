package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$x;
/* автоматически подтягивать либы для впервые использующихся библиотек ALT+ENTER*/
public class KlavogonkiStep {
    private final SelenideElement closeWindowButton = $x ("//input[@value='Закрыть']");
    private final SelenideElement startGameButton = $x("//a[@id='host_start']");

    @When("Start tha game")
    public void startTheGame()
    {
        closeWindowButton.click();
        if(startGameButton.isDisplayed()){startGameButton.click();}

    }
}
