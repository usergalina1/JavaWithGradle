package toolsqa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class PracticeFormPOMTests extends TestBase{



    @Test
    void fillOutTheForm() {





        driver.findElement(By.cssSelector("#firstName")).sendKeys("Peter");
        driver.findElement(By.cssSelector("#lastName")).sendKeys("First");
        driver.findElement(By.cssSelector("#userEmail")).sendKeys("first@gmail.com");
        driver.findElement(By.cssSelector("[for=gender-radio-1]")).click();
        driver.findElement(By.cssSelector("#userNumber")).sendKeys("1234567890");

        driver.findElement(By.cssSelector("#dateOfBirthInput")).click();
        driver.findElement(By.xpath("//select[@class = 'react-datepicker__month-select']/option[@value = '3']")).click();
        driver.findElement(By.xpath("//select[@class = 'react-datepicker__year-select']/option[@value = '1970']")).click();
        driver.findElement(By.xpath("//div[@class = 'react-datepicker__day react-datepicker__day--014'][contains(text(),  '14')]")).click();

        driver.findElement(By.cssSelector("#subjectsInput")).sendKeys("Arts");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[text()='Arts'])[2]"))).click();

        driver.findElement(By.cssSelector("#uploadPicture")).sendKeys("C:\\Users\\galin\\Git\\JavaWithGradle\\src\\test\\resources\\img\\4.png");

        driver.findElement(By.cssSelector("[for=hobbies-checkbox-3]")).click();
        driver.findElement(By.cssSelector("#currentAddress")).sendKeys("2052 N Lincoln Park W, Chicago, Il, 64014 ");

        WebElement state = driver.findElement(By.cssSelector("#state"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", state);

        driver.findElement(By.xpath("//*[@class=' css-tlfecz-indicatorContainer']")).click();
        driver.findElement(By.xpath("//div[contains(text(),'Haryana')]")).click();
        driver.findElement(By.cssSelector("#city")).click();
        driver.findElement(By.xpath("//*[text()='Karnal']")).click();
        driver.findElement(By.cssSelector("#submit")).click();

        Assertion assertion = new Assertion();
        assertion.assertEquals("Thanks for submitting the form", driver.findElement(By.cssSelector(".modal-title")).getText());
        WebElement student = driver.findElement(By.xpath("//td[text()='Student Name']"));
        assertion.assertTrue(student.getText().contains("Student Name"));
        WebElement studentName = driver.findElement(By.xpath("//td[text()='Peter First']"));
        assertion.assertTrue(studentName.getText().contains("Peter First"));
        WebElement gender = driver.findElement(By.xpath("//td[text()='Male']"));
        assertion.assertTrue(gender.getText().contains("Male"));
        WebElement dateOfBirth = driver.findElement(By.xpath("//td[text()='14 April,1970']"));
        assertion.assertTrue(dateOfBirth.getText().contains("14 April,1970"));
        WebElement hobbies = driver.findElement(By.xpath("//td[text()='Hobbies']"));
        assertion.assertTrue(hobbies.getText().contains("Hobbies"));
        WebElement picture = driver.findElement(By.xpath("//td[text()='4.png']"));
        assertion.assertTrue(picture.getText().contains("4.png"));
        WebElement stateAndCity = driver.findElement(By.xpath("//td[text()='Haryana Karnal']"));
        assertion.assertTrue(stateAndCity.getText().contains("Haryana Karnal"));

        WebElement closeBtn = driver.findElement(By.cssSelector("#closeLargeModal"));
        js.executeScript("arguments[0].click();", closeBtn);

        WebElement form = driver.findElement(By.cssSelector(".main-header"));
        js.executeScript("arguments[0].scrollIntoView();", form);
        assertion.assertTrue(form.getText().contains("Practice Form"));

        driver.quit();
    }
}
