package peopleDataSet;


import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//  This class generates National Insurance (NI) numbers and logs the count of NI numbers by country of birth.
public class NINumberGenerator {


    //Generates a new National Insurance (NI) number based on the provided information.
    public static String newNINumber(UserData userData) {
        String firstName = userData.getFirstName();
        String lastName = userData.getLastName();
        String dateOfBirth = userData.getDateOfBirth();
        String countryOfBirth = userData.getCountryOfBirth();

        // Extract the last two digits of the birth year
        String birthYear = dateOfBirth.substring(2, 4);

        // Generate four random digits
        Random random = new Random();
        int randomDigits = random.nextInt(9000) + 1000;
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


}

