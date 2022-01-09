package toolsqa.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import toolsqa.pages.BasePage;

public class ModalSubmittedForm extends BasePage {

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
        jsClick(driver, elCloseModal);
        return this;
    }

    public ModalSubmittedForm modalWindowShouldBePresent() {
        waitVisibility(driver, elModalContent);
        return this;
    }

    public ModalSubmittedForm modalWindowShouldNotBePresent() {
        waitInvisibility(driver, elModalContent);
        return this;
    }

    public ModalSubmittedForm isNotModalWindowPresent() {
        Assert.assertEquals(
                driver.findElements(By.cssSelector(MODAL_CONTENT)).size(),
                0
        );
        return this;
    }
}
