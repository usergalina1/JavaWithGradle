package toolsqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class RegistrationPage {


    //locators and elements
    private final String FIRST_NAME_FIELD = "#firstName";
    private final String LAST_NAME_FIELD = "#lastName";
    private final String EMAIL_FIELD = "#userEmail";
    private final String GENDER_MALE_RADIO_BTN = "[for=gender-radio-1]";
    private final String GENDER_FEMALE_RADIO_BTN = "[for=gender-radio-2]";
    private final String GENDER_OTHER_RADIO_BTN = "[for=gender-radio-3]";
    private final String PHONE_NUMBER_FIELD = "#userNumber";
    private final String DATE_OF_BIRTH_FIELD = "#dateOfBirthInput";
    private final String MONTH_OF_BIRTH_PICKER = ".react-datepicker__month-dropdown-container .react-datepicker__month-select";
    private final String YEAR_OF_BIRTH_PICKER = ".react-datepicker__year-dropdown-container .react-datepicker__year-select";
    private final String SUBJECT_FIELD = "#subjectsInput";
    private final String SELECT_PICTURE = "#uploadPicture";
    private final String SELECT_HOBBIES_SPORTS_CHECKBOX = "[for=hobbies-checkbox-1]";
    private final String SELECT_HOBBIES_READING_CHECKBOX = "[for=hobbies-checkbox-2]";
    private final String SELECT_HOBBIES_MUSIC_CHECKBOX = "[for=hobbies-checkbox-3]";
    private final String ADDRESS_FIELD = "#currentAddress";
    private final String SCROLL_TO_STATE_FIELD = "#state";
    private final String STATE_FIELD = "#state [class*='indicatorContainer']";
    private final String CITY_FIELD = "#city";
    private final String SUBMIT_BTN = "#submit";
    private final String NAME_OF_FORM = ".main-header";

    private WebDriver driver;

    @FindBy(css = FIRST_NAME_FIELD)
    private WebElement elFirstNameField;
    @FindBy(css = LAST_NAME_FIELD)
    private WebElement elLastNameField;
    @FindBy(css = EMAIL_FIELD)
    private WebElement elEmailField;
    @FindBy(css = GENDER_MALE_RADIO_BTN)
    private WebElement elGenderMaleRadioBtn;
    @FindBy(css = GENDER_FEMALE_RADIO_BTN)
    private WebElement elGenderFemaleRadioBtn;
    @FindBy(css = GENDER_OTHER_RADIO_BTN)
    private WebElement elGenderOtherRadioBtn;
    @FindBy(css = PHONE_NUMBER_FIELD)
    private WebElement elPhoneNumberField;
    @FindBy(css = DATE_OF_BIRTH_FIELD)
    private WebElement elDateOfBirthField;
    @FindBy(css = MONTH_OF_BIRTH_PICKER)
    private WebElement elMonthOfBirthPicker;
    @FindBy(css = YEAR_OF_BIRTH_PICKER)
    private WebElement elYearOfBirthPicker;
    @FindBy(css = SUBJECT_FIELD)
    private WebElement elSubjectField;
    @FindBy(css = SELECT_PICTURE)
    private WebElement elSelectPicture;
    @FindBy(css = SELECT_HOBBIES_SPORTS_CHECKBOX)
    private WebElement elSelectHobbiesSportsCheckbox;
    @FindBy(css = SELECT_HOBBIES_READING_CHECKBOX)
    private WebElement elSelectHobbiesReadingCheckbox;
    @FindBy(css = SELECT_HOBBIES_MUSIC_CHECKBOX)
    private WebElement elSelectHobbiesMusicCheckbox;
    @FindBy(css = ADDRESS_FIELD)
    private WebElement elAddressField;
    @FindBy(css = SCROLL_TO_STATE_FIELD)
    private WebElement elScrollToStateField;
    @FindBy(css = STATE_FIELD)
    private WebElement elStateField;
    @FindBy(css = CITY_FIELD)
    private WebElement elCityField;
    @FindBy(css = SUBMIT_BTN)
    private WebElement elSubmitBtn;
    @FindBy(css = NAME_OF_FORM)
    private WebElement elNameOfForm;


    //actions
    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public RegistrationPage fillFirstNameField(String value) {
        elFirstNameField.sendKeys(value);
        return this;
    }

    public RegistrationPage fillLastNameField(String value) {
        elLastNameField.sendKeys(value);
        return this;
    }

    public RegistrationPage fillEmailField(String value) {
        elEmailField.sendKeys(value);
        return this;
    }

    public RegistrationPage clickGenderRadioBtn(String gender) {
        if (gender.equals("Male")) {
            elGenderMaleRadioBtn.click();
        } else if (gender.equals("Female")) {
            elGenderFemaleRadioBtn.click();
        } else {
            elGenderOtherRadioBtn.click();
        }
        return this;
    }

    public RegistrationPage fillPhoneNumberField(String value) {
        elPhoneNumberField.sendKeys(value);
        return this;
    }

    public RegistrationPage fillDateOfBirthField(String month, String date, String year) {
        elDateOfBirthField.click();
        elMonthOfBirthPicker.click();
        Select selectMonthOfBirth = new Select(elMonthOfBirthPicker);
        selectMonthOfBirth.selectByValue(month);
        elYearOfBirthPicker.click();
        Select elYearOfBirthField = new Select(elYearOfBirthPicker);
        elYearOfBirthField.selectByValue(year);
        WebElement elDateOfBirthPicker = driver.findElement(By.xpath("//div[text()= '" + date + "']"));
        elDateOfBirthPicker.click();
        return this;
    }

    public RegistrationPage fillSubjectField(String subject) {
        elSubjectField.sendKeys(subject);
        return this;
    }

    public RegistrationPage selectPicture(String path) {
        elSelectPicture.sendKeys(path);
        return this;
    }

    public RegistrationPage selectHobbiesCheckbox(String hobby) {
        if (hobby.equals("Sports")) {
            elSelectHobbiesSportsCheckbox.click();
        } else if (hobby.equals("Reading")) {
            elSelectHobbiesReadingCheckbox.click();
        } else {
            elSelectHobbiesMusicCheckbox.click();
        }
        return this;
    }

    public RegistrationPage fillAddressField(String address) {
        elAddressField.sendKeys(address);
        return this;
    }

    public RegistrationPage scrollToStateField() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView();",
                driver.findElement(By.cssSelector("#state"))
        );
        return this;
    }

    public RegistrationPage selectState(String state) {
        elStateField.click();
        WebElement statefield = driver.findElement(By.xpath("//div[@id='state']//div[text()='" + state + "']"));
        Actions actions = new Actions(driver);
        actions
                .moveToElement(statefield)
                .click()
                .perform();
        return this;
    }

    public RegistrationPage selectCity(String city) {
        elCityField.click();
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

    public RegistrationPage verifyNameOfForm(String form) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", elNameOfForm);
        Assert.assertTrue(elNameOfForm.getText().contains(form));
        return this;
    }

    public RegistrationPage waitAndClickVisibilityOfElementByText() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Arts'])[2]"))).click();
        return this;
    }
}

