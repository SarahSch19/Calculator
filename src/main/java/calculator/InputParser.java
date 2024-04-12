package calculator;

public class InputParser {
    public final String filePath;
    public final Character operand;

    public InputParser (String[] args) throws Exception {
        if (args.length != 2) {
            throw new Exception("Expected two (2) arguments : filePath operand");
        }
        if (args[0].isEmpty()) {
            throw new Exception("File path can't be empty");
        }
        this.filePath = args[0];
        if (args[1].length() != 1) {
            throw new Exception("Operand must be one character only");
        }
        this.operand = args[1].charAt(0);
    }
}
