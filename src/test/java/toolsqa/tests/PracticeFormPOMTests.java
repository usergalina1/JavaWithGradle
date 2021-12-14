package toolsqa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import toolsqa.pages.RegistrationPage;
import toolsqa.pages.SubmittedFormPage;
import toolsqa.pages.widgets.Calendar;
import toolsqa.pages.widgets.Gender;
import toolsqa.pages.widgets.Hobbies;

public class PracticeFormPOMTests extends TestBase {

    RegistrationPage registrationPage;
    SubmittedFormPage submittedFormPage;
    Calendar calendar;

    @BeforeMethod
    void setUp() {
        registrationPage = new RegistrationPage(driver);
        submittedFormPage = new SubmittedFormPage(driver);
        calendar = new Calendar(driver);
    }

    @Test
    void fillOutTheForm() {
        registrationPage
                .fillFirstNameField("Peter")
                .fillLastNameField("First")
                .fillEmailField("first@gmail.com")
                .clickGender(Gender.Male)
                .fillPhoneNumberField("1234567890");
        calendar
                .fillDateOfBirthField("3", "14", "1970");
        registrationPage
                .fillSubjectField("Arts")
                .waitAndClickVisibilityOfElementByText()
                .selectPicture("C:\\Users\\galin\\Git\\JavaWithGradle\\src\\test\\resources\\img\\4.png")
                .selectHobbies(Hobbies.Music)
                .fillAddressField("2052 N Lincoln Park W, Chicago, Il, 64014")
                .scrollToStateField()
                .selectState("Haryana")
                .selectCity("Karnal")
                .submitForm();
        submittedFormPage
                .waitTitleOfSubmittedForm("Thanks for submitting the form");
    }

    @Test
    void verifySubmittedForm(){
        registrationPage
                .fillFirstNameField("Peter")
                .fillLastNameField("First")
                .fillEmailField("first@gmail.com")
                .clickGender(Gender.Other)
                .fillPhoneNumberField("1234567890");
        calendar
                .fillDateOfBirthField("3", "14", "1970");
        registrationPage
                .fillSubjectField("Arts")
                .waitAndClickVisibilityOfElementByText()
                .selectPicture("C:\\Users\\galin\\Git\\JavaWithGradle\\src\\test\\resources\\img\\4.png")
                .selectHobbies(Hobbies.Reading)
                .fillAddressField("2052 N Lincoln Park W, Chicago, Il, 64014")
                .scrollToStateField()
                .selectState("Haryana")
                .selectCity("Karnal")
                .submitForm();
        submittedFormPage
                .waitTitleOfSubmittedForm("Thanks for submitting the form")
                .verifyStudentName("Peter First")
                .verifyGender(Gender.Other.name())
                .verifyPhoneNumber("1234567890")
                .verifyDateOfBirth("14 April,1970")
                .verifySubjects("Arts")
                .verifyHobbies(Hobbies.Reading.name())
                .verifyPicture("4.png")
                .verifyAddress("2052 N Lincoln Park W, Chicago, Il, 64014")
                .verifyStateAndCity("Haryana Karnal")
                .closeModal()
                .waitModalContentIsNotPresent();
    }
}

