import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LaunchChrome extends BaseClassForMethods{


   @Test
    public void elementsTextFromClickMe(){
        usePropertyAndMaximize();

        driver.navigate().to(" https://demoqa.com/elements");
        driver.findElement(By.id("item-4")).click();//нажатие по "Buttons"
        driver.findElement(By.xpath("//*[text()='Click Me']")).click(); //нажатие по "Click Me" без установки задержки
        String textAfterClick = driver.findElement(By.xpath("//p[@id=\"dynamicClickMessage\"]")).getText(); //поиск содержащегося текста получился только через XPath
        System.out.println(textAfterClick);

        finishDriver();
    }
    @Test
    public void addNewRecordInWebTables(){
        usePropertyAndMaximize();

        driver.navigate().to("https://demoqa.com/webtables");
        driver.findElement(By.id("addNewRecordButton")).click();
      //  fillDataForWebTablesAndSubmit("First", "Second", "uuu@gmail.com", 1, 1000, "newDep");
        fillNameWT("First");
        fillLastNameWT("Second");
        fillEmailWT("uuu@gmail.com");
        fillAgeWT(1);
        fillSalaryWT(1000);
        fillDepartmentWT("newDep");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"edit-record-4\"]")).click(); //edit

        // clearDataFromTables(); //clean input field
        // fillDataForWebTablesAndSubmit("NewFirstName", "NewLastName", "changemail@gmail.com", 50, 20000, "changed Department");

        fillNameWT("NewFirstName");
        fillLastNameWT("NewLastName");
        fillEmailWT("changemail@gmail.com");
        fillAgeWT(50);
        fillSalaryWT(20000);
        fillDepartmentWT("changed Department");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        finishDriver();
    }
}
