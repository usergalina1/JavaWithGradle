package toolsqa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import toolsqa.pages.RegistrationPage;
import toolsqa.pages.widgets.Calendar;
import toolsqa.pages.widgets.Gender;
import toolsqa.pages.widgets.Hobbies;
import toolsqa.pages.widgets.ModalSubmittedForm;

public class PracticeFormPOMTests extends TestBase {
    String firstName = "Peter";
    String lastName = "First";
    String email = "first@gmail.com";
    String phone = "1234567890";
    String month = "3";
    String date = "14";
    String year = "1970";
    String subject = "Arts";
    String picture = "C:\\Users\\galin\\Git\\JavaWithGradle\\src\\test\\resources\\img\\4.png";
    String address = "2052 N Lincoln Park W, Chicago, Il, 64014";
    String state = "Haryana";
    String city = "Karnal";

    RegistrationPage registrationPage;
    ModalSubmittedForm modalSubmittedForm;
    Calendar calendar;

    @BeforeMethod
    void setUp() {
        registrationPage = new RegistrationPage(driver);
        modalSubmittedForm = new ModalSubmittedForm(driver);
        calendar = new Calendar(driver);
    }

    @Test
    void fillOutTheForm() {
        registrationPage
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(email)
                .clickGender(Gender.Male)
                .fillPhoneNumber(phone);
        calendar
                .fillDate(month, date, year);
        registrationPage
                .fillSubject(subject)
                .uploadPicture(picture)
                .selectHobby(Hobbies.Music)
                .fillAddress(address)
                .selectState(state)
                .selectCity(city)
                .submitForm();
        modalSubmittedForm
                .modalWindowShouldBePresent();
    }

    @Test
    void verifySubmittedForm() {
        registrationPage
                .fillFirstName(firstName)
                .fillLastName(lastName)
                .fillEmail(email)
                .clickGender(Gender.Other)
                .fillPhoneNumber(phone);
        calendar
                .fillDate(month, date, year);
        registrationPage
                .fillSubject(subject)
                .uploadPicture(picture)
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
                .checkRow("Date of Birth", date + " " + "April" + "," + year)
                .checkRow("Subjects", subject)
                .checkRow("Hobbies", Hobbies.Reading.name())
                .checkRow("Picture", "4.png")
                .checkRow("Address", address)
                .checkRow("State and City", state + " " + city)
                .closeModal()
                .modalWindowShouldNotBePresent();
    }
}

