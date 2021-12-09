package toolsqa.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeFormTests {
    WebDriver driver;
    WebDriverWait wait;


    @Test
    void fillOutTheForm() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://demoqa.com/automation-practice-form");

        driver.findElement(By.cssSelector("#firstName")).sendKeys("Peter");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("First");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("first@gmail.com");
        driver.findElement(By.cssSelector("[for=gender-radio-1]")).click();
        driver.findElement(By.cssSelector("#userNumber")).sendKeys("1234567890");

        driver.findElement(By.cssSelector("#dateOfBirthInput")).click();
//        driver.findElement(By.xpath("//select[@class = 'react-datepicker__month-select']/option[@value = '3']")).click();
//        driver.findElement(By.xpath("//select[@class = 'react-datepicker__year-select']/option[@value = '1970']")).click();
//        driver.findElement(By.xpath("//div[@class = 'react-datepicker__day react-datepicker__day--014'][contains(text(),  '14')]")).click();
        driver.findElement(By.cssSelector("[value='3']")).click();
        driver.findElement(By.cssSelector(".react-datepicker__year-select [value='1970']")).click();
        driver.findElement(By.cssSelector(".react-datepicker__day--014")).click();

        driver.findElement(By.cssSelector("#subjectsInput")).sendKeys("Arts");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Arts'])[2]"))).click();

        driver.findElement(By.cssSelector("#uploadPicture")).sendKeys("C:\\Users\\galin\\Git\\JavaWithGradle\\src\\test\\resources\\img\\4.png");

        driver.findElement(By.cssSelector("[for=hobbies-checkbox-3]")).click();
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys("2052 N Lincoln Park W, Chicago, Il, 64014 ");

        js.executeScript(
                "arguments[0].scrollIntoView();",
                driver.findElement(By.cssSelector("#state"))
        );

//        driver.findElement(By.xpath("//*[@class=' css-tlfecz-indicatorContainer']")).click();
//        driver.findElement(By.cssSelector("#state .css-tlfecz-indicatorContainer")).click();
        driver.findElement(By.cssSelector("#state [class*='indicatorContainer']")).click();
        driver.findElement(By.xpath("//*[text()='Haryana']")).click();
        driver.findElement(By.cssSelector("#city")).click();
        driver.findElement(By.xpath("//*[text()='Karnal']")).click();
        driver.findElement(By.cssSelector("#submit")).click();

        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.cssSelector(".modal-title")), "Thanks for submitting the form"));

        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='Student Name']//following-sibling::td")).getText(),
                "Peter First"
        );
        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='Gender']//following-sibling::td")).getText(),
                "Male"
        );
        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='Mobile']//following-sibling::td")).getText(),
                "1234567890"
        );
        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='Date of Birth']//following-sibling::td")).getText(),
                "14 April,1970"
        );
        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='Subjects']//following-sibling::td")).getText(),
                "Arts"
        );
        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='Hobbies']//following-sibling::td")).getText(),
                "Music"
        );
        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='Picture']//following-sibling::td")).getText(),
                "4.png"
        );
        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='Address']//following-sibling::td")).getText(),
                "2052 N Lincoln Park W, Chicago, Il, 64014"
        );
        Assert.assertEquals(
                driver.findElement(By.xpath("//td[text()='State and City']//following-sibling::td")).getText(),
                "Haryana Karnal"
        );

        js.executeScript(
                "arguments[0].click();",
                driver.findElement(By.cssSelector("#closeLargeModal"))
        );

        WebElement form = driver.findElement(By.cssSelector(".main-header"));
        js.executeScript("arguments[0].scrollIntoView();", form);
        Assert.assertTrue(form.getText().contains("Practice Form"));

        driver.quit();
    }
}

