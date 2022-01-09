package toolsqa.support;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Conditions extends JSMethods {

    int TIMEOUT = 5;

    public WebDriverWait wait(WebDriver driver, int TIMEOUT) {
        return new WebDriverWait(driver, TIMEOUT);
    }

    public WebElement waitVisibility(WebDriver driver, WebElement element) {
        return wait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitInvisibility(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitElementToBeClickable(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitElementToBeClickable(WebDriver driver, String text) {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[text()='" + text + "']"))));
    }
}
