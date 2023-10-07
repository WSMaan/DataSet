import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import peopledataset.generator.NINumberGenerator;
import peopledataset.userdata.UserData;


import static org.testng.AssertJUnit.assertEquals;

public class NINumberGeneratorTest {

    private NINumberGenerator niNumberGenerator;
    @BeforeEach
    void setUp() {
         niNumberGenerator = new NINumberGenerator();
    }

    @Test
    void testNewNINumber() {
        UserData userData = new UserData("Jon", "Dean", "1999-12-12", "England");
        String NINumber = niNumberGenerator.generateNINumberForTheGivenUserData(userData);
        assertEquals(NINumber.length(), 9);
        assertEquals(NINumber.charAt(0), 'J');
        assertEquals(NINumber.charAt(1), 'D');
        assertEquals(NINumber.charAt(3), '9');
        assertEquals(NINumber.charAt(NINumber.length() - 1), 'E');

    }
}
