import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import peopledataset.utility.DataReaderUtil;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {
    private DataReaderUtil dataReader;
    @BeforeEach
    void setUp(){
        dataReader=new DataReaderUtil();
    }
    @Test
    void testIntegration() {
        String filePath = "src/main/resources/sample.csv";


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
