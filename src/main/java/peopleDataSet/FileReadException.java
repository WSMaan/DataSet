package peopleDataSet;

import java.io.IOException;

import static peopledataset.DataReaderUtil.LOGGER;

 // Custom exception class for handling file read errors.

public class FileReadException extends RuntimeException {

//      Constructs a new FileReadException with an error message and logs the exception.
        public FileReadException(IOException e) {

            LOGGER.severe("An error occurred while reading the file: " + e.getMessage());
            e.printStackTrace();
        }
    }

