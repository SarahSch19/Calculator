package calculator;

public class Main {
    public static void main(String[] args) {
        try {
            InputParser parser = new InputParser(args);

            CSVReader reader = new CSVReader(parser.filePath);
            reader.readLine();
            int[] inputs = reader.parseIntLine();

            Calculator calculator = new Calculator(inputs, parser.operand);
            calculator.calculate();
            calculator.printResult();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}