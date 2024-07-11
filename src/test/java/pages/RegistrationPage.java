package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
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


    public void openPage() {
        open(path);

        pageTitle.shouldHave(text(PAGE_TITLE_TEXT));
        formTitle.shouldHave(text(FORM_TITLE_TEXT));
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

    public void setBirthDate(String day, String month, String year) {
        birthDateInput.click();
        registrationCalendar.setDate(day, month, year);
    }

    public void setSubject(String subject) {
        subjectInput.sendKeys(subject);
        subjectList.findBy(text(subject)).click();
    }

    public void setHobby(String hobby) {
        hobbyInput.$(byText(hobby)).click();
    }

    public void setPicture(String picture) {
        pictureInput.uploadFromClasspath(picture);
    }

    public void setCurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);
    }

    public void setState(String state) {
        stateInput.click();
        stateInput.$(byText(state)).click();
    }

    public void setCity(String city) {
        cityInput.click();
        cityInput.$(byText(city)).click();
    }

    public void submit() {
        submitInput.click();
    }

    public void verifyRegistrationResultAppear() {
        registrationResult.verifyResultComponentAppears(SUCCESS_REG_TEXT);
    }

    public void verifyRegistrationResult (String key, String value) {
        registrationResult.verifyResult(key, value);
    }
}
