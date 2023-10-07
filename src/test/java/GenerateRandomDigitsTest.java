import org.junit.jupiter.api.Test;
import peopleDataSet.NINumberGenerator;

import static org.testng.AssertJUnit.assertTrue;

public class GenerateRandomDigitsTest {

    @Test
    void testGenerateRandomDigits() {
        int randomDigits = NINumberGenerator.generateRandomDigits();
        assertTrue(randomDigits >= 1000 && randomDigits <= 9999);
    }
}
