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
        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text(phoneNumber));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text(birthDate + " " + birthMonth + "," + birthYear));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text(subject));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text(hobby));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text(picture));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text(state + " " + city));
    }

    @Test
    void fillPracticeFormTestWithFluent() {

        registrationPageWithFluent.openPage()
                .setFirstName(firstName)
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
        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text(phoneNumber));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text(birthDate + " " + birthMonth + "," + birthYear));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text(subject));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text(hobby));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text(picture));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text(state + " " + city));
    }
}
