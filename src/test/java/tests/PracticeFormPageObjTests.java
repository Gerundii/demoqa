package tests;

import org.junit.jupiter.api.Test;

import static utils.PracticeFormDatafaker.*;

public class PracticeFormPageObjTests extends BaseTest {
    String firstName = pfData.generateFirstName();
    String lastName = pfData.generateLastName();
    String email = pfData.generateEmail();
    String gender = pfData.generateGender();
    String phoneNumber = pfData.generatePhoneNumber();
    String birthDate = pfData.generateBirthDate();
    String birthMonth = pfData.generateBirthMonth();
    String birthYear = pfData.generateBirthYear();
    String subject = pfData.generateSubject();
    String hobby = pfData.generateHobby();
    String picture = "avatar.jpg";
    String currentAddress = pfData.generateCurrentAddress();
    String state = pfData.generateState();
    String city = pfData.generateCity(state);

    @Test
    void fillPracticeFormTest() throws InterruptedException {

        registrationPage.openPage();
        registrationPage.setFirstName(firstName);
        registrationPage.setLastName(lastName);
        registrationPage.setEmail(email);
        registrationPage.setGender(gender);
        registrationPage.setMobile(phoneNumber);
        registrationPage.setBirthDate(birthDate, birthMonth, birthYear);
        registrationPage.setSubject(subject);
        registrationPage.setHobby(hobby);
        registrationPage.setPicture(picture);
        registrationPage.setCurrentAddress(currentAddress);
        registrationPage.setState(state);
        registrationPage.setCity(city);
        registrationPage.submit();

        registrationPage.verifyRegistrationResultAppear();

        //Assertions
        registrationPage.verifyRegistrationResult("Student Name", firstName + " " + lastName);
        registrationPage.verifyRegistrationResult("Gender", gender);
        registrationPage.verifyRegistrationResult("Mobile", phoneNumber);
        registrationPage.verifyRegistrationResult("Date of Birth", birthDate + " " + birthMonth + "," + birthYear);
        registrationPage.verifyRegistrationResult("Subjects", subject);
        registrationPage.verifyRegistrationResult("Hobbies", hobby);
        registrationPage.verifyRegistrationResult("Picture", picture);
        registrationPage.verifyRegistrationResult("Address", currentAddress);
        registrationPage.verifyRegistrationResult("State and City", state + " " + city);
    }

    @Test
    void fillPracticeFormTestWithFluent() {

        registrationPageWithFluent.openPage();

        registrationPageWithFluent.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setMobile(phoneNumber)
                .setBirthDate(birthDate, birthMonth, birthYear)
                .setSubject(subject)
                .setHobby(hobby)
                .setPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .submit();

        registrationPageWithFluent.verifyRegistrationResultAppear();

        //Assertions
        registrationPageWithFluent.verifyRegistrationResult("Student Name", firstName + " " + lastName)
                .verifyRegistrationResult("Gender", gender)
                .verifyRegistrationResult("Mobile", phoneNumber)
                .verifyRegistrationResult("Date of Birth", birthDate + " " + birthMonth + "," + birthYear)
                .verifyRegistrationResult("Subjects", subject)
                .verifyRegistrationResult("Hobbies", hobby)
                .verifyRegistrationResult("Picture", picture)
                .verifyRegistrationResult("Address", currentAddress)
                .verifyRegistrationResult("State and City", state + " " + city);
    }
}
