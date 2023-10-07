package peopleDataSet;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;



public class DataReaderUtil {
    private NINumberGenerator niNumberGenerator;
    private final Logger LOGGER = Logger.getLogger("PeopleDataSet.TestDataReaderUtil");

    // Reads data from a CSV file, generates National Insurance (NI) numbers, and counts them by country code.

    public Map<String, Integer> readCSV(String file) {
        Map<String, Integer> count = new HashMap<>();
        List<UserData> userList = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file));
             CSVParser csvParser = CSVParser.parse(reader, CSVFormat.DEFAULT.withHeader())) {

            for (CSVRecord record : csvParser) {
                // Extract user data using column names
                String firstName = record.get("First names");
                String lastName = record.get("Last name");
                String dateOfBirth = record.get("Date of Birth");
                String countryOfBirth = record.get("Country of Birth");

                // Create a UserData object and add it to the list
                UserData userData = new UserData(firstName, lastName, dateOfBirth, countryOfBirth);
                userList.add(userData);
            }

            // Generate NI numbers and count them by country code
            for (UserData user : userList) {
                String nin = niNumberGenerator.generateNINumberForTheGivenUserData(user);
                char countryCode = nin.charAt(nin.length() - 1);
                count.put(String.valueOf(countryCode), count.getOrDefault(String.valueOf(countryCode), 0) + 1);
            }
        } catch (IOException e) {
            LOGGER.severe("An Error Has Occurred: " + e.getMessage());
            throw new FileReadException(e);
        }
        return count;
    }
}
