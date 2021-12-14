package toolsqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import toolsqa.pages.widgets.Gender;
import toolsqa.pages.widgets.Hobbies;

public class RegistrationPage {

    private final String FIRST_NAME = "#firstName";
    private final String LAST_NAME = "#lastName";
    private final String EMAIL = "#userEmail";
    private final String GENDER_MALE = "[for=gender-radio-1]";
    private final String GENDER_FEMALE = "[for=gender-radio-2]";
    private final String GENDER_OTHER = "[for=gender-radio-3]";
    private final String PHONE_NUMBER = "#userNumber";
    private final String SUBJECT = "#subjectsInput";
    private final String UPLOAD_PICTURE = "#uploadPicture";
    private final String HOBBIES_SPORTS = "[for=hobbies-checkbox-1]";
    private final String HOBBIES_READING = "[for=hobbies-checkbox-2]";
    private final String HOBBIES_MUSIC = "[for=hobbies-checkbox-3]";
    private final String ADDRESS = "#currentAddress";
    private final String STATE = "#state";
    private final String CITY = "#city";
    private final String SUBMIT = "#submit";
    private final String NAME_OF_FORM = ".main-header";

    private WebDriver driver;

    @FindBy(css = FIRST_NAME)
    private WebElement elFirstName;
    @FindBy(css = LAST_NAME)
    private WebElement elLastName;
    @FindBy(css = EMAIL)
    private WebElement elEmail;
    @FindBy(css = GENDER_MALE)
    private WebElement elGenderMale;
    @FindBy(css = GENDER_FEMALE)
    private WebElement elGenderFemale;
    @FindBy(css = GENDER_OTHER)
    private WebElement elGenderOther;
    @FindBy(css = PHONE_NUMBER)
    private WebElement elPhoneNumber;
    @FindBy(css = SUBJECT)
    private WebElement elSubject;
    @FindBy(css = UPLOAD_PICTURE)
    private WebElement elUploadPicture;
    @FindBy(css = HOBBIES_SPORTS)
    private WebElement elHobbiesSports;
    @FindBy(css = HOBBIES_READING)
    private WebElement elHobbiesReading;
    @FindBy(css = HOBBIES_MUSIC)
    private WebElement elHobbiesMusic;
    @FindBy(css = ADDRESS)
    private WebElement elAddress;
    @FindBy(css = STATE)
    private WebElement elState;
    @FindBy(css = CITY)
    private WebElement elCity;
    @FindBy(css = SUBMIT)
    private WebElement elSubmitBtn;
    @FindBy(css = NAME_OF_FORM)
    private WebElement elNameOfForm;


    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public RegistrationPage fillFirstNameField(String value) {
        elFirstName.sendKeys(value);
        return this;
    }

    public RegistrationPage fillLastNameField(String value) {
        elLastName.sendKeys(value);
        return this;
    }

    public RegistrationPage fillEmailField(String value) {
        elEmail.sendKeys(value);
        return this;
    }

    public RegistrationPage clickGender(Gender gender) {

        if (gender.equals(Gender.Male)) {
            elGenderMale.click();
        } else if (gender.equals(Gender.Female)) {
            elGenderFemale.click();
        } else {
            elGenderOther.click();
        }
        return this;
    }

    public RegistrationPage fillPhoneNumberField(String value) {
        elPhoneNumber.sendKeys(value);
        return this;
    }

    public RegistrationPage fillSubjectField(String subject) {
        elSubject.sendKeys(subject);
        return this;
    }

    public RegistrationPage selectPicture(String path) {
        elUploadPicture.sendKeys(path);
        return this;
    }

    public RegistrationPage selectHobbies(Hobbies hobby) {
        if (hobby.equals(Hobbies.Sports)) {
            elHobbiesSports.click();
        } else if (hobby.equals(Hobbies.Reading)) {
            elHobbiesReading.click();
        } else {
            elHobbiesMusic.click();
        }
        return this;
    }

    public RegistrationPage fillAddressField(String address) {
        elAddress.sendKeys(address);
        return this;
    }

    public RegistrationPage scrollToStateField() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView();", elState
        );
        return this;
    }

    public RegistrationPage selectState(String state) {
        elState.click();
        WebElement statefield = driver.findElement(By.xpath("//div[@id='state']//div[text()='" + state + "']"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(statefield)
                .click()
                .perform();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        elCity.click();
        WebElement cityfield = driver.findElement(By.xpath("//div[@id='city']//div[text()='" + city + "']"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(cityfield)
                .click()
                .perform();
        return this;
    }

    public RegistrationPage submitForm() {
        elSubmitBtn.click();
        return this;
    }

    public RegistrationPage waitAndClickVisibilityOfElementByText() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Arts'])[2]"))).click();
        return this;
    }
}

