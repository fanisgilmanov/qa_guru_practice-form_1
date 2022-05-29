package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticeForm_Tests {
    String firstName = "Fanis";
    String lastName = "Gilmanov";
    String userEmail = "test@mail.ru";
    String gender = "Male";
    String hobbies = "Sports";
    String userNumber = "8987937283";
    String currentAddress = "Russia, Ufa, Ultra";
    String state = "NCR";
    String City = "Delhi";
    File file = new File("src/test/java/resources/Screenshot_practice_form.png");

    @BeforeAll
    static void beforeUrl() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successfulTest() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1994");
        $(".react-datepicker__day--026").click();
        $(".subjects-auto-complete__value-container").click();
        $("#subjectsInput").sendKeys("English");
        $("#subjectsInput").pressEnter();
        $("#hobbiesWrapper").$(byText(hobbies)).click();
        $("#uploadPicture").uploadFile(file);
        $("#currentAddress").setValue(currentAddress);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(City).pressEnter();
        $("#submit").click();




        $(".modal-content").shouldHave(text(firstName), text(lastName),  text(userEmail),
                text(gender), text(userNumber), text(userNumber), text("26 April,1994"), text(hobbies), text("Screenshot_practice_form.png"),
                text(currentAddress), text(state + " " + City));
    }
}
