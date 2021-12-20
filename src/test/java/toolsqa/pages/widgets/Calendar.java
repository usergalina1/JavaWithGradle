package toolsqa.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Calendar {

    private final String DATE = "#dateOfBirthInput";
    private final String MONTH = ".react-datepicker__month-dropdown-container .react-datepicker__month-select";
    private final String YEAR = ".react-datepicker__year-dropdown-container .react-datepicker__year-select";

    private WebDriver driver;

    @FindBy(css = DATE)
    private WebElement elDate;
    @FindBy(css = MONTH)
    private WebElement elMonth;
    @FindBy(css = YEAR)
    private WebElement elYear;

    public Calendar(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public Calendar fillDate(String month, String date, String year) {
        elDate.click();
        elMonth.click();
        new Select(elMonth).selectByValue(month);
        elYear.click();
        new Select(elYear).selectByValue(year);
        driver.findElement(By.xpath("//div[text()= '" + date + "']")).click();
        return this;
    }
}
