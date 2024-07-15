package utils;

import net.datafaker.Faker;

import java.util.Locale;

public class Datafaker {
    static Faker faker = new Faker(new Locale("en"));

    String[] genders = {"Male", "Female", "Other"};
    String[] subjects = {"Maths", "Art", "Biology", "Civics", "Physics"};
    String[] hobbies = {"Male", "Female", "Other"};

    public static String generateFirstName(){
        return faker.name().firstName();
    }

    public static String generateLastName(){
        return faker.name().lastName();
    }

    public static String generateEmail(){
        return faker.internet().emailAddress();
    }

    public static String generateGender(){
        return faker.internet().emailAddress();
    }

    public static String generatePhoneNumber(){
        return faker.internet().emailAddress();
    }

    public static String generateBirthDate(){
        return faker.internet().emailAddress();
    }

    public static String generateBirthMonth(){
        return faker.internet().emailAddress();
    }

    public static String generateBirthYear(){
        return faker.internet().emailAddress();
    }

    public static String generateSubject(){
        return faker.internet().emailAddress();
    }

    public static String generateHobby(){
        return faker.internet().emailAddress();
    }

    public static String generatePicture(){
        return faker.internet().emailAddress();
    }

    public static String generateCurrentAddress(){
        return faker.internet().emailAddress();
    }

    public static String generateState(){
        return faker.internet().emailAddress();
    }

    public static String generateCity(){
        return faker.internet().emailAddress();
    }
}
