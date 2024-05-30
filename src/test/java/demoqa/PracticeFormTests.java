package demoqa;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests extends BaseTest{
    String firstName = "Alex";
    String lastName = "Haikin";
    String email = "al.hai@mail.ru";
    String phoneNumber = "89996663322";
    String currentAddress = "Russia, Moscow";
    String permanentAddress = "France, Nàntt";
    int randomNum = (int) (Math.random() * 3 + 1);;

    @Test
    void fillPracticeFormTest() {
        open("/automation-practice-form");
        $(By.cssSelector(".text-center")).shouldHave(text("Practice Form"));

        $(By.cssSelector("#firstName")).setValue(firstName);
        $(By.cssSelector("#lastName")).setValue(lastName);
        $(By.cssSelector("#userEmail")).setValue(email);
        $(By.cssSelector("#gender-radio-" + randomNum)).parent().click();
        $(By.cssSelector("#gender-radio-" + randomNum)).shouldBe(selected);
        $(By.cssSelector("#userNumber")).setValue(phoneNumber);
        $(By.cssSelector("#dateOfBirthInput")).click();
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
