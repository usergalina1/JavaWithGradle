package toolsqa.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import toolsqa.dictionary.Gender;
import toolsqa.dictionary.Hobbies;

import java.util.List;

public class RegistrationPage extends Page {

    private final String FIRST_NAME = "#firstName";
    private final String LAST_NAME = "#lastName";
    private final String EMAIL = "#userEmail";
    private final String GENDER_MALE = "[for=gender-radio-1]";
    private final String GENDER_FEMALE = "[for=gender-radio-2]";
    private final String GENDER_OTHER = "[for=gender-radio-3]";
    private final String PHONE_NUMBER = "#userNumber";
    private final String SUBJECT = "#subjectsInput";
    private final String FILE = "#uploadPicture";
    private final String HOBBIES_SPORTS = "[for=hobbies-checkbox-1]";
    private final String HOBBIES_READING = "[for=hobbies-checkbox-2]";
    private final String HOBBIES_MUSIC = "[for=hobbies-checkbox-3]";
    private final String ADDRESS = "#currentAddress";
    private final String STATE = "#state";
    private final String CITY = "#city";
    private final String SUBMIT = "#submit";
    private final String REQUIRED_FIELDS = "input:required";

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
    @FindBy(css = FILE)
    private WebElement elFile;
    @FindBy(css = HOBBIES_SPORTS)
    private WebElement elHobbySports;
    @FindBy(css = HOBBIES_READING)
    private WebElement elHobbyReading;
    @FindBy(css = HOBBIES_MUSIC)
    private WebElement elHobbyMusic;
    @FindBy(css = ADDRESS)
    private WebElement elAddress;
    @FindBy(css = STATE)
    private WebElement elState;
    @FindBy(css = CITY)
    private WebElement elCity;
    @FindBy(css = SUBMIT)
    private WebElement elSubmitBtn;
    @FindBy(css = REQUIRED_FIELDS)
    private List<WebElement> elRequiredFields;

    public RegistrationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public RegistrationPage fillFirstName(String name) {
        elFirstName.sendKeys(name);
        return this;
    }

    public RegistrationPage fillLastName(String name) {
        elLastName.sendKeys(name);
        return this;
    }

    public RegistrationPage fillEmail(String email) {
        elEmail.sendKeys(email);
        return this;
    }

    public RegistrationPage clickGender(Gender gender) {
//        if (gender.equals(Gender.Male)) {
//            elGenderMale.click();
//        } else if (gender.equals(Gender.Female)) {
//            elGenderFemale.click();
//        } else if (gender.equals(Gender.Other)){
//            elGenderOther.click();
//        }
//        return this;
//  OR
        switch (gender.name()) {
            case ("Male"):
                elGenderMale.click();
                break;
            case ("Female"):
                elGenderFemale.click();
                break;
            case ("Other"):
                elGenderOther.click();
                break;
            default:
                throw new RuntimeException("Unsupported gender " + gender);
        }
        return this;
    }

    public RegistrationPage clickGenderMale(Gender male){
        elGenderMale.click();
        return this;
    }

    public RegistrationPage clickGenderFemale(Gender female){
        elGenderFemale.click();
        return this;
    }

    public RegistrationPage clickGenderOther(Gender other){
        elGenderOther.click();
        return this;
    }



    public RegistrationPage fillPhone(String phone) {
        elPhoneNumber.sendKeys(phone);
        return this;
    }

    public RegistrationPage fillSubject(String subject) {
        elSubject.sendKeys(subject);
        elSubject.sendKeys(Keys.ENTER);
        return this;
    }

    public RegistrationPage uploadPicture(String path) {
        elFile.sendKeys(path);
        return this;
    }

    public RegistrationPage selectHobby(Hobbies hobby) {
//        if (hobby.equals(Hobbies.Sports)) {
//            elHobbySports.click();
//        } else if (hobby.equals(Hobbies.Reading)) {
//            elHobbyReading.click();
//        } else {
//            elHobbyMusic.click();
//        }
//        return this;
//  OR
        switch (hobby.name()) {
            case ("Sports"):
                elHobbySports.click();
                break;
            case ("Reading"):
                elHobbyReading.click();
                break;
            case ("Music"):
                elHobbyMusic.click();
                break;
        }
        return this;
    }

    public RegistrationPage fillAddress(String address) {
        elAddress.sendKeys(address);
        return this;
    }

    public RegistrationPage selectState(String state) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView();", elState
        );

        elState.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[text()='" + state + "']"))))
                .click();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        elCity.click();
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[text()='" + city + "']"))))
                .click();
        return this;
    }

    public RegistrationPage submitForm() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elSubmitBtn);
        elSubmitBtn.click();
        return this;
    }

    public  RegistrationPage verifyRequiredFields(){
        for (WebElement field : elRequiredFields){
            Assert.assertTrue(Boolean.parseBoolean(field.getAttribute("required")), "Field is required");
        }
        return this;
    }
}

