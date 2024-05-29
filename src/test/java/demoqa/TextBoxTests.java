package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests extends BaseTest{
    String name = "Alex Haikin";
    String email = "al.hai@mail.ru";
    String currentAddress = "Russia, Moscow";
    String permanentAddress = "France, Nàntt";

    @Test
    void fillFormTest() {
        open("/text-box");
        $(By.cssSelector(".text-center")).shouldHave(text("Text Box"));

        $(By.cssSelector("#userName")).setValue(name);
        $(By.cssSelector("#userEmail")).setValue(email);
        $(By.cssSelector("#currentAddress")).setValue(currentAddress);
        $(By.cssSelector("#permanentAddress")).setValue(permanentAddress);
        $(By.cssSelector("#submit")).scrollTo();
        $(By.cssSelector("#submit")).click();

        $(By.cssSelector("#output")).shouldBe(visible);
        $(By.cssSelector("#output")).$(By.cssSelector("#name")).shouldHave(text(name));
        $(By.cssSelector("#output")).$(By.cssSelector("#email")).shouldHave(text(email));
        $(By.cssSelector("#output")).$(By.cssSelector("#currentAddress")).shouldHave(text(currentAddress));
        $(By.cssSelector("#output")).$(By.cssSelector("#permanentAddress")).shouldHave(text(permanentAddress));
        String result = $(By.cssSelector("#output")).$(By.cssSelector("#permanentAddress")).getText();
        System.out.println(result);

    }
}
