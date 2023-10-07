package peopleDataSet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static peopleDataSet.NINumberGenerator.newNINumber;


// This utility class provides methods for reading data from a CSV file and processing it.

public class DataReaderUtil {
    public static final Logger LOGGER = Logger.getLogger("PeopleDataSet.TestDataReaderUtil");

    // Reads data from a CSV file, generates National Insurance (NI) numbers, and counts them by country code.
    public Map<String, Integer> readCSV(String file) {
        Map<String, Integer> count = new HashMap<>();
        List<UserData> userList = new LinkedList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            reader.readLine();

            String line = reader.readLine();
            while (line != null) {
                String[] fields = line.split(",");

                // Extract user data from CSV fields
                String firstName = fields[0];
                String lastName = fields[1];
                String dateOfBirth = fields[6];
                String countryOfBirth = fields[7];

                // Create a UserData object and add it to the list
                UserData userData = new UserData(firstName, lastName, dateOfBirth, countryOfBirth);
                userList.add(userData);

                line = reader.readLine();
            }
            reader.close();

            // Generate NI numbers and count them by country code
            for (UserData user : userList) {
                String nin = newNINumber(user);
                char countryCode = nin.charAt(nin.length() - 1);
                count.put(String.valueOf(countryCode), count.getOrDefault(String.valueOf(countryCode), 0) + 1);
            }

        } catch (IOException e) {
            LOGGER.severe("An error has occurred: " + e.getMessage());
            throw new FileReadException(e);
        }
        return count;
    }
}
