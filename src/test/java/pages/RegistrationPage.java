package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement genderInput = $("#genterWrapper");
    private SelenideElement mobileInput = $("#userNumber");

    public void openPage() {
        open("/automation-practice-form");

        $(".text-center").shouldHave(text("Practice Form"));
        $(".practice-form-wrapper h5").shouldHave(text(TITLE_TEXT));
    }

    public void setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
    }

    public void setLastName(String lastName) {
        lastNameInput.setValue(lastName);
    }

    public void setEmail(String email) {
        emailInput.setValue(email);
    }

    public void setGender(String gender) {
        genderInput.$(byText(gender)).click();
    }

    public void setMobile(String phoneNumber) {
        mobileInput.setValue(phoneNumber);
    }
}
