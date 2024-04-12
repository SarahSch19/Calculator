package calculator;

import java.io.*;
import java.util.Arrays;

public class CSVReader {
    private final InputStream inputStream;
    private final BufferedReader reader;
    private String line = "";

    public CSVReader(String filename) throws Exception {
        try {
            this.inputStream = new FileInputStream(filename);
            this.reader = new BufferedReader(new InputStreamReader(this.inputStream));
        } catch (IOException e) {
            throw new Exception("Error opening file " + filename);
        }
    }

    public String getLine() {
        return line;
    }

    public void readLine() throws Exception {
        try {
            String l = reader.readLine();
            this.line = l != null ? l : "";

        } catch (IOException e) {
            throw new RuntimeException("Error reading file");
        }
    }

    public int[] parseIntLine() {
        if (this.line.isEmpty()) return new int[]{};
        return Arrays.stream(this.line.split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
    }
}
