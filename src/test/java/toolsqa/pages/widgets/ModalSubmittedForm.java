package toolsqa.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import toolsqa.pages.Page;

public class ModalSubmittedForm extends Page {

    private final String CLOSE_MODAL = "#closeLargeModal";
    private final String MODAL_CONTENT = ".modal-content";

    private WebDriver driver;

    @FindBy(css = CLOSE_MODAL)
    private WebElement elCloseModal;
    @FindBy(css = MODAL_CONTENT)
    private WebElement elModalContent;

    public ModalSubmittedForm(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ModalSubmittedForm checkRow(String line, String expectedText) {
        String actualText = driver.findElement(By.xpath("//td[text()='" + line + "']//following-sibling::td")).getText();
        Assert.assertEquals(actualText, expectedText);
        return this;
    }

    public ModalSubmittedForm closeModal() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", elCloseModal);
        return this;
    }

    public ModalSubmittedForm modalWindowShouldBePresent() {
        waitVisibilityOfElementLocated(driver, MODAL_CONTENT);
        return this;
    }

    public ModalSubmittedForm modalWindowShouldNotBePresent() {
        waitInvisibilityOfElementLocated(driver, MODAL_CONTENT);
        return this;
    }
}
