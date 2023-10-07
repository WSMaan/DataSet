package peopleDataSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class NINumberGenerator {
    //Generates four random digits
    public static int generateRandomDigits() {
        Random random = new Random();
        return random.nextInt(9000) + 1000;
    }

    // Constructs a National Insurance (NI) number based on the provided information
    public static String constructNINumber(UserData userData, int randomDigits) {
        String firstName = userData.getFirstName();
        String lastName = userData.getLastName();
        String dateOfBirth = userData.getDateOfBirth();
        String countryOfBirth = userData.getCountryOfBirth();

        // Extract the last two digits of the birth year
        String birthYear = dateOfBirth.substring(2, 4);

        Map<String, Character> countryCodes = new HashMap<>();
        countryCodes.put("England", 'E');
        countryCodes.put("Northern Ireland", 'N');
        countryCodes.put("Scotland", 'S');
        countryCodes.put("Wales", 'W');
        countryCodes.put("Non-UK", 'O');

        char countryCode = countryCodes.getOrDefault(countryOfBirth, 'O');

        // Construct the NI number
        StringBuilder nin = new StringBuilder();
        nin.append(firstName.charAt(0))
                .append(lastName.charAt(0))
                .append(birthYear)
                .append(randomDigits)
                .append(countryCode);

        return nin.toString();
    }

    //Generates a new National Insurance (NI) number based on the provided information.
    public static String generateNINumberForTheGivenUserData(UserData userData) {
        int randomDigits = generateRandomDigits();
        return constructNINumber(userData, randomDigits);
    }
}
