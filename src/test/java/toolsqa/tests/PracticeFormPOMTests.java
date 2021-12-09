package toolsqa.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import toolsqa.pages.RegistrationPage;
import toolsqa.pages.SubmittedFormPage;

public class PracticeFormPOMTests extends TestBase {

    RegistrationPage registrationPage;
    SubmittedFormPage submittedFormPage;

    @BeforeMethod
    void setUp() {
        registrationPage = new RegistrationPage(driver);
        submittedFormPage = new SubmittedFormPage(driver);
    }

    @Test
    void fillOutTheForm() {

        registrationPage.fillFirstNameField("Peter")
                .fillLastNameField("First")
                .fillEmailField("first@gmail.com")
                .clickGenderRadioBtn("Female")
                .fillPhoneNumberField("1234567890")
                .fillDateOfBirthField("3", "14", "1970")
                .fillSubjectField("Arts")
                .waitAndClickVisibilityOfElementByText()
                .selectPicture("C:\\Users\\galin\\Git\\JavaWithGradle\\src\\test\\resources\\img\\4.png")
                .selectHobbiesCheckbox("Music")
                .fillAddressField("2052 N Lincoln Park W, Chicago, Il, 64014")
                .scrollToStateField()
                .selectState("Haryana")
                .selectCity("Karnal")
                .submitForm();

        submittedFormPage.waitTitleOfSubmittedForm("Thanks for submitting the form")
                .verifyStudentName("Peter First")
                .verifyGender("Female")
                .verifyPhoneNumber("1234567890")
                .verifyDateOfBirth("14 April,1970")
                .verifySubjects("Arts")
                .verifyHobbies("Music")
                .verifyPicture("4.png")
                .verifyAddress("2052 N Lincoln Park W, Chicago, Il, 64014")
                .verifyStateAndCity("Haryana Karnal")
                .clickCloseBtn();

        registrationPage.verifyNameOfForm("Practice Form");
    }
}

