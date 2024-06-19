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
    String hobbie = "Music";
    String picture = "avatar.jpg";
    String currentAddress = "Russia, Moscow";
    String state = "Haryana";
    String city = "Karnal";

    @Test
    void fillPracticeFormTest() {

        registrationPage.openPage();
        //Name
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        //Email
        registrationPage.setEmail(email);
        //Gender
        registrationPage.setGender(gender);
        //Mobile
        registrationPage.setMobile(phoneNumber);

        //Date of Birth
        registrationPage.setBirthDate(birthDate, birthMonth, birthYear);

        //Subjects
        $("#subjectsInput").sendKeys(subject);
        $$(".subjects-auto-complete__option").findBy(text(subject)).click();

        //Hobbies
        $("#hobbiesWrapper").$(byText(hobbie)).click();

        //Picture
        $("#uploadPicture").uploadFromClasspath(picture);

        //Current Address
        $("#currentAddress").setValue(currentAddress);

        //State
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();

        //Cite
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        //Submit
        $("#submit").click();

        //Assertions
        $(".table-responsive").$(byText("Student Name")).sibling(0).shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Student Email")).sibling(0).shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).sibling(0).shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).sibling(0).shouldHave(text(phoneNumber));
        $(".table-responsive").$(byText("Date of Birth")).sibling(0).shouldHave(text(birthDate + " " + birthMonth + "," + birthYear));
        $(".table-responsive").$(byText("Subjects")).sibling(0).shouldHave(text(subject));
        $(".table-responsive").$(byText("Hobbies")).sibling(0).shouldHave(text(hobbie));
        $(".table-responsive").$(byText("Picture")).sibling(0).shouldHave(text("avatar.jpg"));
        $(".table-responsive").$(byText("Address")).sibling(0).shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).sibling(0).shouldHave(text(state + " " + city));
    }
}
