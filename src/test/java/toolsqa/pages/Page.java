package toolsqa.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {

    private WebDriver driver;

    public Page(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void openURL(){
        driver.get("https://demoqa.com/automation-practice-form");
    }

    public WebElement waitVisibilityOfElementLocated(WebDriver driver, String css){
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
    }

    public WebElement waitInvisibilityOfElementLocated(WebDriver driver, String css){
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
    }

}
