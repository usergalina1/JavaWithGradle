package toolsqa.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Calendar {

    private final String DATE_OF_BIRTH_INPUT = "#dateOfBirthInput";
    private final String MONTH_OF_BIRTH_PICKER = ".react-datepicker__month-dropdown-container .react-datepicker__month-select";
    private final String YEAR_OF_BIRTH_PICKER = ".react-datepicker__year-dropdown-container .react-datepicker__year-select";

    private WebDriver driver;

    @FindBy(css = DATE_OF_BIRTH_INPUT)
    private WebElement elDateOfBirthInput;
    @FindBy(css = MONTH_OF_BIRTH_PICKER)
    private WebElement elMonthOfBirthPicker;
    @FindBy(css = YEAR_OF_BIRTH_PICKER)
    private WebElement elYearOfBirthPicker;

    public Calendar(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Calendar fillDateOfBirthField(String month, String date, String year) {
        elDateOfBirthInput.click();
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
}
