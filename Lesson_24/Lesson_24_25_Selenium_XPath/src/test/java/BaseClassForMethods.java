import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClassForMethods
{
    WebDriver driver = new ChromeDriver();
    boolean driverIsWorking = true;

    public void usePropertyAndMaximize()
        {
                if (driverIsWorking == false)
                {
                    driver = new ChromeDriver();
                    driverIsWorking = true;
                }
            System.clearProperty("webdriver.chrome.driver");
            System.setProperty("webdriver.chrome.driver", "C:\\webdrivers\\chromedriver.exe");
            driver.manage().window().maximize();
        }
public boolean finishDriver()
{
    try{
        Thread.sleep(2000);
    }
    catch (InterruptedException e){
        e.printStackTrace();
    }
    driver.quit();

    return driverIsWorking = false;
}
  /*  public void fillDataForWebTablesAndSubmit(String name, String lastName, String email, int age, int salary, String department)
    {
        String ageString = String.valueOf(age);
        String salaryString = String.valueOf(salary);

        driver.findElement(By.id("firstName")).sendKeys(name);
        driver.findElement(By.id("lastName")).sendKeys(lastName);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("age")).sendKeys(ageString);
        driver.findElement(By.id("salary")).sendKeys(salaryString);
        driver.findElement(By.id("department")).sendKeys(department);


        clearDataFromTables(); //clean input field
    }*/
    public void fillNameWT(String name)
    {
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("firstName")).sendKeys(name);
    }
    public void fillLastNameWT(String lastName)
    {
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("lastName")).sendKeys(lastName);
    }
    public void fillEmailWT(String email)
    {
        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("userEmail")).sendKeys(email);
    }
    public void fillAgeWT(int age)
    {
        String ageString = String.valueOf(age);
        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("age")).sendKeys(ageString);
    }
    public void fillSalaryWT(int salary)
    {
        String salaryString = String.valueOf(salary);
        driver.findElement(By.id("salary")).clear();
        driver.findElement(By.id("salary")).sendKeys(salaryString);
    }
    public void fillDepartmentWT(String department)
    {
        driver.findElement(By.id("department")).clear();
        driver.findElement(By.id("department")).sendKeys(department);
    }

   /* public void clearDataFromTables()
    {
        driver.findElement(By.id("firstName")).clear();
        driver.findElement(By.id("lastName")).clear();
        driver.findElement(By.id("userEmail")).clear();
        driver.findElement(By.id("age")).clear();
        driver.findElement(By.id("salary")).clear();
        driver.findElement(By.id("department")).clear();

    }*/
}
