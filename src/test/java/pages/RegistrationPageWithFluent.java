package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPageWithFluent {
    private final String path = "/automation-practice-form";
    private CalendarComponent registrationCalendar = new CalendarComponent();
    private ResultComponent registrationResult = new ResultComponent();
    private final String PAGE_TITLE_TEXT = "Practice Form";
    private final String FORM_TITLE_TEXT = "Student Registration Form";
    private final String SUCCESS_REG_TEXT = "Thanks for submitting the form";
    private SelenideElement pageTitle = $(".text-center");
    private SelenideElement formTitle = $(".practice-form-wrapper h5");
    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement emailInput = $("#userEmail");
    private SelenideElement genderInput = $("#genterWrapper");
    private SelenideElement mobileInput = $("#userNumber");
    private SelenideElement birthDateInput = $("#dateOfBirthInput");
    private SelenideElement subjectInput = $("#subjectsInput");
    private ElementsCollection subjectList = $$(".subjects-auto-complete__option");
    private SelenideElement hobbyInput = $("#hobbiesWrapper");
    private SelenideElement pictureInput = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement stateInput = $("#state");
    private SelenideElement cityInput = $("#city");
    private SelenideElement submitInput = $("#submit");


    public RegistrationPageWithFluent openPage() {
        open(path);

        pageTitle.shouldHave(text(PAGE_TITLE_TEXT));
        formTitle.shouldHave(text(FORM_TITLE_TEXT));
        return this;
    }

    public RegistrationPageWithFluent setFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPageWithFluent setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPageWithFluent setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPageWithFluent setGender(String gender) {
        genderInput.$(byText(gender)).click();
        return this;
    }

    public RegistrationPageWithFluent setMobile(String phoneNumber) {
        mobileInput.setValue(phoneNumber);
        return this;
    }

    public RegistrationPageWithFluent setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        registrationCalendar.setDate(day, month, year);
        return this;
    }

    public RegistrationPageWithFluent setSubject(String subject) {
        subjectInput.sendKeys(subject);
        subjectList.findBy(text(subject)).click();
        return this;
    }

    public RegistrationPageWithFluent setHobby(String hobby) {
        hobbyInput.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPageWithFluent setPicture(String picture) {
        pictureInput.uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPageWithFluent setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
        return this;
    }

    public RegistrationPageWithFluent setState(String state) {
        stateInput.click();
        stateInput.$(byText(state)).click();
        return this;
    }

    public RegistrationPageWithFluent setCity(String city) {
        cityInput.click();
        cityInput.$(byText(city)).click();
        return this;
    }

    public RegistrationPageWithFluent submit() {
        submitInput.click();
        return this;
    }

    public RegistrationPageWithFluent verifyRegistrationResultAppear() {
        registrationResult.verifyResultComponentAppears(SUCCESS_REG_TEXT);
        return this;
    }

    public RegistrationPageWithFluent verifyRegistrationResult (String key, String value) {
        registrationResult.verifyResult(key, value);
        return this;
    }
}
