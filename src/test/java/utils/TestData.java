package utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Set;

public class TestData {

    private static final Set<String> MONTHS31 = Set.of("January", "March", "May", "July", "August", "October", "December");
    private static final Set<String> MONTHS30 = Set.of("April", "June", "September", "November");

    public Faker faker = new Faker(new Locale("en"));

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(firstName + lastName),
            gender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            calendarYear = String.valueOf(faker.number().numberBetween(1900, 2100)),
            calendarMonth = faker.options().option(
                    "December", "January", "February",
                    "March", "April", "May", "June",
                    "July", "August", "September",
                    "October", "November"),
            calendarDay = getRandomDay(),
            subject = faker.options().option("Maths", "Chemistry", "English", "Computer Science"),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            file = faker.options().option("Example.jpg", "Example1.jpg"),
            currentAddress = faker.address().country(),
            permanentAddress = faker.address().country(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getRandomCity(state);


    public String getRandomDay() {
        if (MONTHS31.contains(calendarMonth)) {
            return String.valueOf(faker.number().numberBetween(0, 31));
        } else if (MONTHS30.contains(calendarMonth)) {
            return String.valueOf(faker.number().numberBetween(0, 30));
        } else if (Integer.parseInt(calendarYear) % 4 == 0) {
            return String.valueOf(faker.number().numberBetween(0, 29));
        } else {
            return String.valueOf(faker.number().numberBetween(0, 28));
        }
    }

    public String getRandomCity(String value) {
        return switch (value) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> throw new IllegalStateException("Unexpected value: " + value);
        };
    }
}
