package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void before() {
        //Configuration.browser = "firefox";
        //Configuration.pageLoadStrategy = "none";
        //Configuration.browserSize = "1920x1080";
        Configuration.pageLoadTimeout = 60000;
        Configuration.holdBrowserOpen = true;
        //Configuration.headless = true;
        Configuration.baseUrl = "https://demoqa.com";
    }
}
