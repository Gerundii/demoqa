package demoqa;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends BaseTest{
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
        open("/automation-practice-form");

        $(".text-center").shouldHave(text("Practice Form"));
        $(".practice-form-wrapper h5").shouldHave(text("Student Registration Form"));

        //Name
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);

        //Email
        $("#userEmail").setValue(email);

        //Gender
        $("#genterWrapper").$(byText(gender)).click();

        //Mobile
        $("#userNumber").setValue(phoneNumber);

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(".react-datepicker__day--0" + birthDate + ":not(.react-datepicker__day--outside-month)").click();

        //Subjects
        $("#subjectsInput").sendKeys(subject);
        $$(".subjects-auto-complete__option").findBy(text(subject)).click();
        //$(".subjects-auto-complete__menu-list").$(byText("Accounting")).click();
        //$("#react-select-2-option-0").click();

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
