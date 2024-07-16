package utils;

import net.datafaker.Faker;

import java.util.Locale;

public class PracticeFormDatafaker {
    Faker faker = new Faker(new Locale("en"));

    private final String[] GENDERS = {"Male", "Female", "Other"};
    private final String[] SUBJECTS = {"Maths", "Art", "Biology", "Civics", "Physics"};
    private final String[] HOBBIES = {"Sports", "Reading", "Music"};
    private final String[] STATE = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    private final String[] CITYNCR = {"Delhi", "Gurgaon", "Noida"};
    private final String[] CITYUttar = {"Agra", "Lucknow", "Merrut"};
    private final String[] CITYHaryana = {"Karnal", "Panipat"};
    private final String[] CITYRajasthan = {"Jaipur", "Jaiselmer"};

    String[] birthDay = generateBirthDay();

    public void main(String[] args) {
    }

    public String generateFirstName() {
        return faker.name().firstName();
    }

    public String generateLastName() {
        return faker.name().lastName();
    }

    public String generateEmail() {
        return faker.internet().emailAddress();
    }

    public String generateGender() {
        return faker.options().option(GENDERS);
    }

    public String generatePhoneNumber() {
        return String.valueOf(faker.number().numberBetween(9010000000L, 9999999999L));
    }

    public String[] generateBirthDay() {
        return birthDay = faker.timeAndDate().birthday(20, 30, "dd MMMM YYYY").split(" ");
    }

    public String generateBirthDate() {
        return birthDay[0];
    }

    public String generateBirthMonth() {
        return birthDay[1];
    }

    public String generateBirthYear() {
        return birthDay[2];
    }

    public String generateSubject() {
        return faker.options().option(SUBJECTS);
    }

    public String generateHobby() {
        return faker.options().option(HOBBIES);
    }

    public String generateCurrentAddress() {
        return faker.address().fullAddress();
    }

    public String generateState() {
        return faker.options().option(STATE);
    }

    public String generateCity(String state) {
        String city = null;
        if (state.equals("NCR")) {
            city = faker.options().option(CITYNCR);
        } else if (state.equals("Uttar Pradesh")) {
            city = faker.options().option(CITYUttar);
        } else if (state.equals("Haryana")) {
            city = faker.options().option(CITYHaryana);
        } else if (state.equals("Rajasthan")) {
            city = faker.options().option(CITYRajasthan);
        }
        return city;
    }
}
