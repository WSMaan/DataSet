import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import peopleDataSet.DataReaderUtil;
import peopleDataSet.NIStatsLogger;



import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DataReaderUtilTest {
    private DataReaderUtil dataReader;
    private NIStatsLogger statsLogger;

    @BeforeEach
    void setUp() {
        dataReader = new DataReaderUtil();
        statsLogger = new NIStatsLogger();
    }

    @Test
    void testReadCSV() {
        String filePath = "src/main/resources/dataset.csv";

        Map<String, Integer> result = dataReader.readCSV(filePath);
        assertNotNull(result);

        statsLogger.logCounts(result);



    }

}
