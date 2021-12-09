package toolsqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SubmitedFormPage {



    //locators and elements
    private final String STUDENT_NAME = "//td[text()='Student Name']//following-sibling::td";
    private final String GENDER = "//td[text()='Gender']//following-sibling::td";
    private final String PHONE_NUMBER = "//td[text()='Mobile']//following-sibling::td";
    private final String DATE_OF_BIRTH = "//td[text()='Date of Birth']//following-sibling::td";
    private final String SUBJECTS = "//td[text()='Subjects']//following-sibling::td";
    private final String HOBBIES = "//td[text()='Hobbies']//following-sibling::td";
    private final String PICTURE = "//td[text()='Picture']//following-sibling::td";
    private final String ADDRESS = "//td[text()='Address']//following-sibling::td";
    private final String STATE_AND_CITY = "//td[text()='State and City']//following-sibling::td";
    private final String CLOSE_BTN = "#closeLargeModal";
    private final String TITLE_OF_SUBMITTED_FORM = ".modal-title";

    private WebDriver driver;

    @FindBy(xpath = STUDENT_NAME)
    private WebElement elStudentName;
    @FindBy(xpath = GENDER)
    private WebElement elGender;
    @FindBy(xpath = PHONE_NUMBER)
    private WebElement elPhoneNumber;
    @FindBy(xpath = DATE_OF_BIRTH)
    private WebElement elDateOfBirth;
    @FindBy(xpath = SUBJECTS)
    private WebElement elSubjects;
    @FindBy(xpath = HOBBIES)
    private WebElement elHobbies;
    @FindBy(xpath = PICTURE)
    private WebElement elPicture;
    @FindBy(xpath = ADDRESS)
    private WebElement elAddress;
    @FindBy(xpath = STATE_AND_CITY)
    private WebElement elStateAndCity;
    @FindBy(css = CLOSE_BTN)
    private WebElement elCloseBtn;
    @FindBy(css = TITLE_OF_SUBMITTED_FORM)
    private WebElement elTitleOfSubmittedForm;

    //actions
    public SubmitedFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
    public SubmitedFormPage verifyStudentName(String name) {
        Assert.assertEquals(elStudentName.getText(), name);
        return this;
    }

    public SubmitedFormPage verifyGender(String gender) {
        Assert.assertEquals(elGender.getText(), gender);
        return this;
    }

    public SubmitedFormPage verifyPhoneNumber(String phone) {
        Assert.assertEquals(elPhoneNumber.getText(), phone);
        return this;
    }

    public SubmitedFormPage verifyDateOfBirth(String dateOfBirth) {
        Assert.assertEquals(elDateOfBirth.getText(), dateOfBirth);
        return this;
    }

    public SubmitedFormPage verifySubjects(String subject) {
        Assert.assertEquals(elSubjects.getText(), subject);
        return this;
    }

    public SubmitedFormPage verifyHobbies(String hobby) {
        Assert.assertEquals(elHobbies.getText(), hobby);
        return this;
    }

    public SubmitedFormPage verifyPicture(String picture) {
        Assert.assertEquals(elPicture.getText(), picture);
        return this;
    }

    public SubmitedFormPage verifyAddress(String address) {
        Assert.assertEquals(elAddress.getText(), address);
        return this;
    }

    public SubmitedFormPage verifyStateAndCity(String stateAndCity) {
        Assert.assertEquals(elStateAndCity.getText(), stateAndCity);
        return this;
    }

    public SubmitedFormPage clickCloseBtn() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].click();",
                driver.findElement(By.cssSelector("#closeLargeModal"))
        );
        return this;
    }
    public SubmitedFormPage waitTitleOfSubmittedForm(String title) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector(".modal-title")), title));
        return this;
    }
}
