package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPageObjTests extends BaseTest {
    String firstName = "Alex";
    String lastName = "Haikin";
    String email = "al.hai@mail.ru";
    String gender = "Other";
    String phoneNumber = "9996663322";
    String birthDate = "30";
    String birthMonth = "April";
    String birthYear = "1985";
    String subject = "Accounting";
    String hobby = "Music";
    String picture = "avatar.jpg";
    String currentAddress = "Russia, Moscow";
    String state = "Haryana";
    String city = "Karnal";

    @Test
    void fillPracticeFormTest() {

        registrationPage.openPage();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(email);
        registrationPage.setGender(gender);
        registrationPage.setMobile(phoneNumber);
        registrationPage.setBirthDate(birthDate, birthMonth, birthYear);
        registrationPage.setSubject(subject);
        registrationPage.setHobby(hobby);
        registrationPage.setPicture(picture);
        registrationPage.setCurrentAddress(currentAddress);
        registrationPage.setState(state);
        registrationPage.setCity(city);
        registrationPage.submit();

        registrationPage.verifyRegistrationResultAppear();

        //Assertions
        registrationPage.verifyRegistrationResult("Student Name", firstName + " " + lastName);
        registrationPage.verifyRegistrationResult("Gender", gender);
        registrationPage.verifyRegistrationResult("Mobile", phoneNumber);
        registrationPage.verifyRegistrationResult("Date of Birth", birthDate + " " + birthMonth + "," + birthYear);
        registrationPage.verifyRegistrationResult("Subjects", subject);
        registrationPage.verifyRegistrationResult("Hobbies", hobby);
        registrationPage.verifyRegistrationResult("Picture", picture);
        registrationPage.verifyRegistrationResult("Address", currentAddress);
        registrationPage.verifyRegistrationResult("State and City", state + " " + city);
    }

    @Test
    void fillPracticeFormTestWithFluent() {

        registrationPageWithFluent.openPage();

        registrationPageWithFluent.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobile(phoneNumber)
                .setBirthDate(birthDate, birthMonth, birthYear)
                .setSubject(subject)
                .setHobby(hobby)
                .setPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit();

        registrationPageWithFluent.verifyRegistrationResultAppear();

        //Assertions
        registrationPageWithFluent.verifyRegistrationResult("Student Name", firstName + " " + lastName)
                .verifyRegistrationResult("Gender", gender)
                .verifyRegistrationResult("Mobile", phoneNumber)
                .verifyRegistrationResult("Date of Birth", birthDate + " " + birthMonth + "," + birthYear)
                .verifyRegistrationResult("Subjects", subject)
                .verifyRegistrationResult("Hobbies", hobby)
                .verifyRegistrationResult("Picture", picture)
                .verifyRegistrationResult("Address", currentAddress)
                .verifyRegistrationResult("State and City", state + " " + city);
    }
}
