package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.RegistrationPage;
import pages.RegistrationPageWithFluent;
import utils.PracticeFormDatafaker;

public class BaseTest {
    RegistrationPage registrationPage = new RegistrationPage();
    RegistrationPageWithFluent registrationPageWithFluent = new RegistrationPageWithFluent();

    @BeforeAll
    static void before() {
        //Configuration.browser = "firefox";
        Configuration.pageLoadStrategy = "none";
        //Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 60000;
        //Configuration.holdBrowserOpen = true;
        //Configuration.headless = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
}
