package StepDefinitions;

import AppiumSupport.AppiumBaseClass;
import AppiumSupport.AppiumController;
import PageObjects.ContactSearchPage;
import PageObjects.ContactSearchPageAndroid;
import Test.BaseTestClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Steps extends AppiumBaseClass {
    ContactSearchPage searchPage;

    @Given("Search page is displayed")
    public void searchPageIsDisplayed() {

     //   return Assert.assertTrue(searchPage.search("Contacts"));
    }

    @When("Input <name>")
    public void inputName() {
    }

    @Then("Found <input_name> in the result line")
    public void foundInput_nameInTheResultLine() {
    }
}
