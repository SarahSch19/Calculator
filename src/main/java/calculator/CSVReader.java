package calculator;

import java.io.*;
import java.util.Arrays;

public class CSVReader {
    private final InputStream inputStream;
    private String line = "";

    public CSVReader(String filename) throws Exception {
        try {
            this.inputStream = new FileInputStream(filename);
        } catch (IOException e) {
            throw new Exception("Error opening file " + filename);
        }
    }

    public String getLine() {
        return line;
    }

    public void readLine() throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.inputStream));
            this.line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Error reading file");
        }
    }

    public int[] parseIntLine() {
        return Arrays.stream(this.line.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
    }
}
