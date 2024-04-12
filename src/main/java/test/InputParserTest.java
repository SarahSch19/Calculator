package test;

import calculator.InputParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InputParserTest {
    private final String testFilePath = "src/test/resources/test.csv";
    private final String testOperand = "+";
    @Test()
    public void testInputParser() {


        try {
            InputParser parser = new InputParser(new String[]{this.testFilePath, this.testOperand});
            assertEquals(this.testFilePath, parser.filePath);
            assertEquals(this.testOperand.charAt(0), parser.operand);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Test()
    public void testEmptyArgs() {
        assertThrows(
                Exception.class,
                () -> new InputParser(new String[]{}),
                "Expected two (2) arguments : filePath operand"
        );
    }

    @Test()
    public void testEmptyFilepathInput() {
        assertThrows(
                Exception.class,
                () -> new InputParser(new String[]{"", "+"}),
                "File path can't be empty"
        );
    }

    @Test()
    public void testEmptyOperandInput() {
        assertThrows(
                Exception.class,
                () -> new InputParser(new String[]{this.testFilePath, ""}),
                "Operand must be one character only"
        );
    }

    @Test()
    public void testInvalidOperandInput() {
        assertThrows(
                Exception.class,
                () -> new InputParser(new String[]{this.testFilePath, "xx"}),
                "Operand must be one character only"
        );
    }
}
