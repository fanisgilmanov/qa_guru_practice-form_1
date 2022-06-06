package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalenderComponent;
import pages.components.ResultsTableComponent;
import pages.components.StateSelect;

import java.io.File;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormPage {

    public CalenderComponent calenderComponent = new CalenderComponent();
    public StateSelect stateSelect = new StateSelect();
    public ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmail = $("#userEmail"),
            gender = $("#genterWrapper"),
            mobileNumber = $("#userNumber"),
            subjectsInput = $("#subjectsInput"),
            hobbiesInput = $("#hobbiesWrapper"),
            uploadFileInput = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }
    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public RegistrationFormPage setEmail(String value) {
        userEmail.setValue(value);

        return this;
    }
    public RegistrationFormPage setGender(String value) {
        gender.$(byText(value)).click();

        return this;
    }
    public RegistrationFormPage setMobileNumber(String value) {
        mobileNumber.setValue(value);

        return this;
    }

    public RegistrationFormPage setDateOfBirth(String date) {
        $("#dateOfBirthInput").click();
        calenderComponent.setDate(date);

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        $(".subjects-auto-complete__value-container").click();
        subjectsInput.sendKeys(value);
        subjectsInput.pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        hobbiesInput.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage uploadFiles(File value){
        uploadFileInput.uploadFile(value);

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;

    }

    public RegistrationFormPage setSelect(String input, String value){
        stateSelect.setSelect(input, value);

        return this;
    }
    public RegistrationFormPage checkResult(String key, String value) {
        resultsTableComponent.checkResult(key, value);

        return this;
    }

}
