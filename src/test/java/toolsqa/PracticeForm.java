package toolsqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeForm {
    WebDriver driver;


    @Test
    void fillOutTheForm(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println();

        driver.quit();



//       driver().get().

    }
}
