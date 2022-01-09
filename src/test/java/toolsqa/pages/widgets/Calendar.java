package toolsqa.pages.widgets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import toolsqa.enums.Months;

public class Calendar {

    private final String DATE = "#dateOfBirthInput";
    private final String MONTH = ".react-datepicker__month-select";
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

    public void fillDate(String month, String date, String year) {
        elDate.click();
        elMonth.click();
//        new Select(elMonth).selectByValue(String.valueOf(month - 1)); // month should be int in the method
//        OR
//        driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']//option[text() ='"+ month +"']")).click();
        driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']//option[text() ='"+ Months.valueOf(month) +"']")).click();
        elYear.click();
        new Select(elYear).selectByValue(year);
        driver.findElement(By.xpath("//div[text()= '" + date + "']")).click();
    }
}
