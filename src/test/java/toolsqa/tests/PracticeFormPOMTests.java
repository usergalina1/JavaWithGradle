package toolsqa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import toolsqa.pages.BasePage;
import toolsqa.pages.RegistrationPage;
import toolsqa.pages.widgets.Calendar;
import toolsqa.enums.Gender;
import toolsqa.enums.Hobbies;
import toolsqa.pages.widgets.ModalSubmittedForm;

public class PracticeFormPOMTests extends TestBase {

    BasePage page;
    RegistrationPage registrationPage;
    ModalSubmittedForm modalSubmittedForm;
    Calendar calendar;

    @BeforeMethod
    void setUp() {
        page = new BasePage(driver);
        registrationPage = new RegistrationPage(driver);
        modalSubmittedForm = new ModalSubmittedForm(driver);
        calendar = new Calendar(driver);
    }

    @Test
    void verifyRequiredFields() {
        page
                .open("https://demoqa.com/automation-practice-form");
        registrationPage
                .submitForm()
                .verifySizeRequiredFields(6);
        modalSubmittedForm
                .isNotModalWindowPresent();
    }

    @Test
    void verifySubmittedForm() {
        String firstName = "Peter";
        String lastName = "First";
        String email = "first@gmail.com";
        String phone = "1234567890";
//        int month = 4;
        String month = "April";
        String date = "14";
        String year = "1970";
        String subject = "Maths";
        String address = "2052 N Lincoln Park W, Chicago, Il, 64014";
        String state = "Haryana";
        String city = "Karnal";

        page
                .open("https://demoqa.com/automation-practice-form");
        registrationPage
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(email)
//                .clickGender(Gender.Other)
//                OR
                .clickGenderOther()
                .fillPhone(phone);
        calendar
                .fillDate(month, date, year);
        registrationPage
                .fillSubject(subject)
                .uploadPicture("C:\\Users\\galin\\Git\\JavaWithGradle\\src\\test\\resources\\img\\4.png")
                .selectHobby(Hobbies.Reading)
                .fillAddress(address)
                .selectState(state)
                .selectCity(city)
                .submitForm();
        modalSubmittedForm
                .modalWindowShouldBePresent()
                .checkRow("Student Name", firstName + " " + lastName)
                .checkRow("Gender", Gender.Other.name())
                .checkRow("Mobile", phone)
//                .checkRow("Date of Birth", date + " " + Months.April.name() + "," + year) //if use enum class
//                OR
                .checkRow("Date of Birth", date + " " + month + "," + year)
                .checkRow("Subjects", subject)
                .checkRow("Hobbies", Hobbies.Reading.name())
                .checkRow("Picture", "4.png")
                .checkRow("Address", address)
                .checkRow("State and City", state + " " + city)
                .closeModal()
                .modalWindowShouldNotBePresent();
    }
}

