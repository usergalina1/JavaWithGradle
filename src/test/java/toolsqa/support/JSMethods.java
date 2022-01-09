package toolsqa.support;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSMethods {

    public JavascriptExecutor executor(WebDriver driver){
        return (JavascriptExecutor) driver;
    }

    public void jsScrollIntoView(WebDriver driver, WebElement element) {
        executor(driver).executeScript("arguments[0].scrollIntoView();", element);
    }

    public void jsClick(WebDriver driver, WebElement element) {
        executor(driver).executeScript("arguments[0].click();", element);
    }
}
