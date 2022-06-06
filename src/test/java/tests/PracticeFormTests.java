package tests;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;



public class PracticeFormTests  extends BaseTest{


    @Test
    void successfulTest() {

        registrationFormPage.openPage()
            .setFirstName(testData.firstName)
            .setLastName(testData.lastName)
            .setEmail(testData.userEmail)
            .setGender(testData.gender)
            .setMobileNumber(testData.userNumber)
            .setDateOfBirth(testData.dateBirthday)
            .setSubject(testData.subject)
            .setHobbies(testData.hobbies)
            .uploadFiles(testData.file)
            .setCurrentAddress(testData.currentAddress)
            .setSelect(testData.stateInput, testData.stateValue)
            .setSelect(testData.cityInput, testData.cityValue);
        $("#submit").click();




         registrationFormPage.checkResult("Student Name", testData.firstName)
            .checkResult("Student Name", testData.lastName)
            .checkResult("Student Email", testData.userEmail)
            .checkResult("Gender", testData.gender)
            .checkResult("Mobile", testData.userNumber)
            .checkResult("Date of Birth", testData.checkDateBirthday)
            .checkResult("Subjects", testData.subject)
            .checkResult("Hobbies", testData.hobbies)
            .checkResult("Picture", testData.file.getName())
            .checkResult("Address", testData.currentAddress)
            .checkResult("State and City", testData.stateValue + " " + testData.cityValue);

    }
}
