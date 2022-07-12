import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LaunchChrome{


    @Test
    public void chromeSession_1(){
        WebDriver driver = new ChromeDriver();
        System.clearProperty("webdriver.chrome.driver");
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe"); //работает только если добавить путь в файлу в Path (в параметрах среды)
        driver.manage().window().maximize();
        driver.navigate().to(" https://demoqa.com/elements");
        WebElement buttons = driver.findElement(By.id("item-4"));
        buttons.click(); //нажатие по "Buttons"
        driver.findElement(By.xpath("//*[text()='Click Me']")).click(); //нажатие по "Click Me" без установки задержки
        String textAfterClick = driver.findElement(By.xpath("//p[@id=\"dynamicClickMessage\"]")).getText(); //поиск содержащегося текста получился только через XPath
        System.out.println(textAfterClick);

       try{
           Thread.sleep(2000);
       }
       catch (InterruptedException e){
           e.printStackTrace();
       }
       driver.quit();
    }
    @Test
    public void chromeSession_2(){

        WebDriver driver = new ChromeDriver();
        System.clearProperty("webdriver.chrome.driver");
        System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/webtables");
        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        addButton.click();

        WebElement firstName = driver.findElement(By.id("firstName")); //start to autofill
        firstName.sendKeys("Qwerty");
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys("Password");
        WebElement email = driver.findElement(By.id("userEmail"));
        email.sendKeys("byPatternazAZ09@azAZ.com");
        WebElement age = driver.findElement(By.id("age"));
        age.sendKeys("20");
        WebElement salary = driver.findElement(By.id("salary"));
        salary.sendKeys("1000");
        WebElement department = driver.findElement(By.id("department"));
        department.sendKeys("u_U_u");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        driver.findElement(By.xpath("//*[@id=\"edit-record-4\"]")).click(); //edit
        WebElement firstNameEdit = driver.findElement(By.id("firstName"));
        firstNameEdit.clear();
        firstNameEdit.sendKeys("New Name");
        driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.quit();
    }
}
