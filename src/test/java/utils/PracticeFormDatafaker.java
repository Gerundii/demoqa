package utils;

import net.datafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PracticeFormDatafaker {
    Faker faker = new Faker(new Locale("en"));

    String[] genders = {"Male", "Female", "Other"};
    String[] subjects = {"Maths", "Art", "Biology", "Civics", "Physics"};
    String[] hobbies = {"Sports", "Reading", "Music"};
    String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    String[] cityNCR = {"Delhi", "Gurgaon", "Noida"};
    String[] cityUttar = {"Agra", "Lucknow", "Merrut"};
    String[] cityHaryana = {"Karnal", "Panipat"};
    String[] cityRajasthan = {"Jaipur", "Jaiselmer"};

    String[] birthDate = faker.timeAndDate().birthday(20, 30, "dd MMMM YYYY").split(" ");

    public void main(String[] args) {
    }

    public String generateFirstName(){
        return faker.name().firstName();
    }

    public String generateLastName(){
        return faker.name().lastName();
    }

    public String generateEmail(){
        return faker.internet().emailAddress();
    }

    public String generateGender(){
        return faker.options().option(genders);
    }

    public String generatePhoneNumber(){
        return String.valueOf(faker.number().numberBetween(9010000000L, 9999999999L));
    }

    public String generateBirthDate(){
        return birthDate[0];
    }

    public String generateBirthMonth(){
        return birthDate[1];
    }

    public String generateBirthYear(){
        return birthDate[2];
    }

    public String generateSubject(){
        return faker.options().option(subjects);
    }

    public String generateHobby(){
        return faker.options().option(hobbies);
    }

    public String generateCurrentAddress(){
        return faker.address().fullAddress();
    }

    public String generateState(){
        return faker.options().option(state);
    }

    public String generateCity(String state){
        String city = null;
        if (state.equals("NCR")) {
            city = faker.options().option(cityNCR);
        }
        else if (state.equals("Uttar Pradesh")) {
            city = faker.options().option(cityUttar);
        }
        else if (state.equals("Haryana")) {
            city = faker.options().option(cityHaryana);
        }
        else if (state.equals("Rajasthan")) {
            city = faker.options().option(cityRajasthan);
        }
        return city;
    }
}
