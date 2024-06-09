package demoqa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests extends BaseTest{
    String firstName = "Alex";
    String lastName = "Haikin";
    String email = "al.hai@mail.ru";
    String phoneNumber = "89996663322";
    String currentAddress = "Russia, Moscow";
    String permanentAddress = "France, Nàntt";
    String birthDate = "030";
    String birthMonth = "April";
    String birthYear = "1985";
    int randomNum = (int) (Math.random() * 3 + 1);;

    @Test
    void fillPracticeFormTest() {
        open("/automation-practice-form");
        $(".text-center").shouldHave(text("Practice Form"));

        //Name
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);

        //Email
        $("#userEmail").setValue(email);

        //Gender
        $("#genterWrapper").$(byText("Other")).click();
        //$(By.cssSelector("#gender-radio-" + randomNum)).parent().click();

        //Mobile
        $("#userNumber").setValue(phoneNumber);

        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(".react-datepicker__day--" + birthDate + ":not(.react-datepicker__day--outside-month)").click();

        //Subjects
        $("#subjectsInput").sendKeys("a");
        $(".subjects-auto-complete__menu").$(byText("Accounting")).click();
        //$(By.cssSelector("label[for=\"hobbies-checkbox-2\"]")).click();
        //$("#react-select-2-option-0").click();

        //Hobbies
        $("#hobbiesWrapper").$(byText("Music")).click();
        //$("label[for*='hobbies-checkbox']").$(byText("Sports")).click();

        //Picture
        $("#uploadPicture").uploadFromClasspath("avatar.jpg");




        /*$(By.cssSelector("#currentAddress")).setValue(currentAddress);
        $(By.cssSelector("#permanentAddress")).setValue(permanentAddress);
        $(By.cssSelector("#submit")).scrollTo();
        $(By.cssSelector("#submit")).click();*/

        /*$(By.cssSelector("#output")).shouldBe(visible);
        $(By.cssSelector("#output")).$(By.cssSelector("#name")).shouldHave(text(name));
        $(By.cssSelector("#output")).$(By.cssSelector("#email")).shouldHave(text(email));
        $(By.cssSelector("#output")).$(By.cssSelector("#currentAddress")).shouldHave(text(currentAddress));
        $(By.cssSelector("#output")).$(By.cssSelector("#permanentAddress")).shouldHave(text(permanentAddress));
        String result = $(By.cssSelector("#output")).$(By.cssSelector("#permanentAddress")).getText();
        System.out.println(result);*/
    }
}
