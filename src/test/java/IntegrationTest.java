import org.junit.jupiter.api.Test;
import peopleDataSet.DataReaderUtil;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {
    @Test
    void testIntegration() {
        String filePath = "src/main/resources/sample.csv";

        DataReaderUtil dataReader = new DataReaderUtil();

        Map<String, Integer> result = dataReader.readCSV(filePath);

        Map<String, Integer> expectedCountsbyCountries = Map.of(
                "E", 2,
                "W", 1,
                "N", 1,
                "S", 1,
                "O", 1
        );
        assertEquals(expectedCountsbyCountries,result);
    }
}
