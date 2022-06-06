package tests;


import com.github.javafaker.Faker;
import java.io.File;
import static utils.RandomUtils.*;


public  class TestData  {

    Faker faker = new Faker();
    String firstName = faker.address().firstName();
    String lastName = faker.address().lastName();
    String userEmail = faker.internet().emailAddress();
    String gender = getRandomGender();
    String subject = getRandomSubject();
    String hobbies = getRandomHobbies();
    String userNumber = getRandomNumber();
    String dateBirthday = getRandomDate();

    String currentAddress = faker.address().streetAddress();
    String stateInput = "#react-select-3-input";
    String stateValue = getRandomState(); // "NCR";
    String cityInput = "#react-select-4-input";
    String cityValue = getRandomCity(stateValue); //"Delhi";
    File file = new File("src/test/resources/Screenshot_practice_form.png");

    String delimeter = " ";
    String[] subStrDate = dateBirthday.split(delimeter);
    String checkDateBirthday = subStrDate[0] + " " + subStrDate[1]+"," + subStrDate[2];
}
