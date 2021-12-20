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

public class ModalSubmittedForm {

    private final String CLOSE_MODAL = "#closeLargeModal";
    private final String MODAL_CONTENT = ".modal-content";

    private WebDriver driver;


    @FindBy(css = CLOSE_MODAL)
    private WebElement elCloseModal;
    @FindBy(css = MODAL_CONTENT)
    private WebElement elModalContent;

    public ModalSubmittedForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ModalSubmittedForm checkRow(String line, String expectedText) {
        Assert.assertEquals(driver
                .findElement(By.xpath("//td[text()='" + line + "']//following-sibling::td"))
                .getText(), expectedText);
        return this;
    }

    public ModalSubmittedForm closeModal() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].click();", elCloseModal
        );
        return this;
    }

    public ModalSubmittedForm modalWindowShouldBePresent() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(MODAL_CONTENT)));
        return this;
    }

    public ModalSubmittedForm modalWindowShouldNotBePresent() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(MODAL_CONTENT)));
        return this;
    }
}
