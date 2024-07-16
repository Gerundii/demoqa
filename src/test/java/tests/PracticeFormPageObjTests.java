package tests;

import model.StudentData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.PracticeFormDatafaker;

import static utils.PracticeFormDatafaker.*;

public class PracticeFormPageObjTests extends BaseTest {
    PracticeFormDatafaker pfData = new PracticeFormDatafaker();

    StudentData student = StudentData.builder()
            .firstName(pfData.generateFirstName())
            .lastName(pfData.generateLastName())
            .email(pfData.generateEmail())
            .gender(pfData.generateGender())
            .phoneNumber(pfData.generatePhoneNumber())
            .birthDate(pfData.generateBirthDate())
            .birthMonth(pfData.generateBirthMonth())
            .birthYear(pfData.generateBirthYear())
            .subject(pfData.generateSubject())
            .hobby(pfData.generateHobby())
            .picture("avatar.jpg")
            .currentAddress(pfData.generateCurrentAddress())
            .state(pfData.generateState())
            .city(pfData.generateCity())
            .build();

    @Test
    void fillPracticeFormTest() throws InterruptedException {

        registrationPage.openPage();
        registrationPage.setFirstName(student.getFirstName());
        registrationPage.setLastName(student.getLastName());
        registrationPage.setEmail(student.getEmail());
        registrationPage.setGender(student.getGender());
        registrationPage.setMobile(student.getPhoneNumber());
        registrationPage.setBirthDate(student.getBirthDate(), student.getBirthMonth(), student.getBirthYear());
        registrationPage.setSubject(student.getSubject());
        registrationPage.setHobby(student.getHobby());
        registrationPage.setPicture(student.getPicture());
        registrationPage.setCurrentAddress(student.getCurrentAddress());
        registrationPage.setState(student.getState());
        registrationPage.setCity(student.getCity());
        registrationPage.submit();

        registrationPage.verifyRegistrationResultAppear();

        //Assertions
        registrationPage.verifyRegistrationResult("Student Name", student.getFirstName() + " " + student.getLastName());
        registrationPage.verifyRegistrationResult("Gender", student.getGender());
        registrationPage.verifyRegistrationResult("Mobile", student.getPhoneNumber());
        registrationPage.verifyRegistrationResult("Date of Birth", student.getBirthDate() + " " + student.getBirthMonth() + "," + student.getBirthYear());
        registrationPage.verifyRegistrationResult("Subjects", student.getSubject());
        registrationPage.verifyRegistrationResult("Hobbies", student.getHobby());
        registrationPage.verifyRegistrationResult("Picture", student.getPicture());
        registrationPage.verifyRegistrationResult("Address", student.getCurrentAddress());
        registrationPage.verifyRegistrationResult("State and City", student.getState() + " " + student.getCity());
    }

    @Test
    void fillPracticeFormTestWithFluent() {

        registrationPageWithFluent.openPage();

        registrationPageWithFluent.setFirstName(student.getFirstName())
                .setLastName(student.getLastName())
                .setEmail(student.getEmail())
                .setGender(student.getGender())
                .setMobile(student.getPhoneNumber())
                .setBirthDate(student.getBirthDate(), student.getBirthMonth(), student.getBirthYear())
                .setSubject(student.getSubject())
                .setHobby(student.getHobby())
                .setPicture(student.getPicture())
                .setCurrentAddress(student.getCurrentAddress())
                .setState(student.getState())
                .setCity(student.getCity())
                .submit();

        registrationPageWithFluent.verifyRegistrationResultAppear();

        //Assertions
        registrationPageWithFluent.verifyRegistrationResult("Student Name", student.getFirstName() + " " + student.getLastName())
                .verifyRegistrationResult("Gender", student.getGender())
                .verifyRegistrationResult("Mobile", student.getPhoneNumber())
                .verifyRegistrationResult("Date of Birth", student.getBirthDate() + " " + student.getBirthMonth() + "," + student.getBirthYear())
                .verifyRegistrationResult("Subjects", student.getSubject())
                .verifyRegistrationResult("Hobbies", student.getHobby())
                .verifyRegistrationResult("Picture", student.getPicture())
                .verifyRegistrationResult("Address", student.getCurrentAddress())
                .verifyRegistrationResult("State and City", student.getState() + " " + student.getCity());
    }
}
