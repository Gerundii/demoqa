package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {

    @Test
    void fillFormTest() {
        Configuration.browser = "firefox";
        open("https://demoqa.com/text-box");
    }
}
