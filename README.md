
---

# National Insurance Number (NI) Generator

This Java project is designed to generate National Insurance (NI) numbers based on individuals' first names, last names, dates of birth, and countries of birth. The project includes two main classes: `NINumberGenerator` and `DataReaderUtil`.

## NINumberGenerator

The `NINumberGenerator` class contains the core functionality for generating NI numbers. It provides the following methods:

- `constructNINumber(UserData userData, int randomDigits)`: This method constructs a National Insurance (NI) number based on the provided `UserData` object and a set of rules:

  - The first two characters are derived from the first letter of the first name and the first letter of the last name.
  - The next two characters represent the last two digits of the year of birth.
  - The subsequent four characters are randomly generated digits.
  - The last character is a country code corresponding to the country of birth.

  Country codes and their corresponding countries are as follows:

  | Country          | Code |
| ---------------| ---- |
  | England          | E    |
  | Northern Ireland | N    |
  | Scotland         | S    |
  | Wales            | W    |
  | Non-UK           | O    |

  Example Output:
  ```
  FirstName: John
  LastName: Smith
  DateOfBirth: 01/01/1998
  CountryOfBirth: England

  NI Number: JS98####E
  ```

- `generateNINumberForTheGivenUserData(UserData userData)`: This method generates a new NI number based on the provided `UserData` object by first generating random digits and then calling `constructNINumber`.

## DataReaderUtil

The `DataReaderUtil` class provides methods for reading data from a CSV file and processing it. The primary method, `readCSV(String file)`, reads data from a CSV file, generates NI numbers for each individual, and counts the numbers by country code. It returns a `Map<String, Integer>` where keys are country codes, and values are the counts of NI numbers for each country.

## NIStatsLogger

The `NIStatsLogger` class is responsible for logging the count of NI numbers by country code. It takes the map generated by `DataReaderUtil` and logs the counts for each country.

## UserData

The `UserData` class is a data model class that holds information about individuals, including their first name, last name, date of birth, and country of birth. It is used to pass this data to the `NINumberGenerator` for generating NI numbers.

## Usage

To use this project, follow these steps:

1. Ensure that you have Java installed on your system.

2. Compile the project using your preferred Java compiler or IDE.

3. Create a CSV file with the data of individuals, including their first names, last names, dates of birth, and countries of birth.

4. Modify the `file` parameter in the `readCSV` method of `DataReaderUtil` to point to your CSV file.

5. Run the project. The counts of NI numbers by country code will be logged to the console.

## Exception Handling

The project handles file reading exceptions using a custom exception class called `FileReadException`. This exception is thrown if an error occurs while reading the CSV file.

---

