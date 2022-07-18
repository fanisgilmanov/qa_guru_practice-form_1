package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;


public class PracticeFormTests  extends BaseTest{


    @Test
    void successfulTest() {
        step("Открываем главную страницу", () -> {
            registrationFormPage.openPage();
        });
        step("Вводим тестовые данные", () -> {
            registrationFormPage.setFirstName(testData.firstName)
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
                    .setSelect(testData.cityInput, testData.cityValue)
                    .clickSubmit();
        });



        step("Проверяем введенные тестовые данные, на корректность", () -> {
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
        });




    }
}
