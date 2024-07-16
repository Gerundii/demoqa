package model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class StudentData {

    String firstName;
    String lastName;
    String email;
    String gender;
    String phoneNumber;
    String birthDate;
    String birthMonth;
    String birthYear;
    String subject;
    String hobby;
    String picture;
    String currentAddress;
    String state;
    String city;
}
