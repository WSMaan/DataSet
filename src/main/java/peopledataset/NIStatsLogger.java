package peopledataset;

import java.util.Map;
import java.util.logging.Logger;

public class NIStatsLogger {
    public static final Logger LOGGER = Logger.getLogger("PeopleDataSet.NIStatsLogger");

    public void logCounts(Map<String, Integer> count) {
        LOGGER.info("Count of NI numbers by country:");
        LOGGER.info("Wales (W): " + count.get("W"));
        LOGGER.info("England (E): " + count.get("E"));
        LOGGER.info("Scotland (S): " + count.get("S"));
        LOGGER.info("Northern Ireland (N): " + count.get("N"));
        LOGGER.info("Other (O): " + count.get("O"));
    }
}