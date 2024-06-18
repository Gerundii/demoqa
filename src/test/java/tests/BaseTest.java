package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;

public class BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void before() {
        //Configuration.browser = "firefox";
        //Configuration.pageLoadStrategy = "none";
        //Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 60000;
        //Configuration.holdBrowserOpen = true;
        //Configuration.headless = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
}
