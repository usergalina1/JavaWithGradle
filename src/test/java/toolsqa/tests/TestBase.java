package toolsqa.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import toolsqa.pages.RegistrationPage;
import toolsqa.pages.SubmitedFormPage;

public class TestBase {

    WebDriver driver;


    @BeforeMethod()
    public WebDriver initialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");
        return driver;
    }

    @AfterMethod()
    public void tearDown(){
        driver.quit();
    }
}
