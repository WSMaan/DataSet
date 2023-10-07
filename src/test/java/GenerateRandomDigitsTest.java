import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import peopledataset.generator.NINumberGenerator;

import static org.testng.AssertJUnit.assertTrue;

public class GenerateRandomDigitsTest {
  private NINumberGenerator niNumberGenerator;
  @BeforeEach
  void setUp(){
      niNumberGenerator=new NINumberGenerator();
  }
    @Test
    void testRandomDigitsOfGeneratedNI() {
        int randomDigits = niNumberGenerator.generateRandomDigits();
        assertTrue(randomDigits >= 1000 && randomDigits <= 9999);
    }
}
