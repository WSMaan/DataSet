import org.junit.jupiter.api.Test;
import peopleDataSet.DataReaderUtil;
import peopleDataSet.FileReadException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DataReaderUtilNotExistTest {
    @Test
    void testReadNonExistentCSV() {
        String filePath = "src/main/resources/non-existent-file.csv";
        DataReaderUtil dataReader = new DataReaderUtil();

        assertThrows(FileReadException.class, () -> dataReader.readCSV(filePath));
    }
}
