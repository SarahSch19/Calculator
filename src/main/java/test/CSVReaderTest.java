package test;

import calculator.CSVReader;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CSVReaderTest {
    private final String testFilePath = "./resources/test.csv";
    private final String expectedLine = "1,2,3";

    @Test()
    public void testInitCSVReader() {
        assertDoesNotThrow(() -> new CSVReader(this.testFilePath));
    }

    @Test()
    public void testInvalidFilePath() {
        assertThrows(Exception.class, () -> new CSVReader("invalid.csv"), "Error opening file invalid.csv");
    }

    @Test()
    public void testReadLine() {
        try {
            CSVReader reader = new CSVReader(this.testFilePath);
            reader.readLine();
            String line = reader.getLine();
            assertEquals(this.expectedLine, line);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
