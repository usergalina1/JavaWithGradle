package toolsqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import toolsqa.support.Conditions;

public class BasePage extends Conditions {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void open(String BaseURL) {
        driver.get(BaseURL);
    }
}
