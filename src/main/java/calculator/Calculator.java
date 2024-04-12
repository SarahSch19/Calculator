package calculator;

public class Calculator {
//    private final Map<Character, Operands> operandsMap = Map.of('+', Operands.PLUS);
    private final int[] inputs;
    private final char operand;
    private int output;

    public Calculator (int[] input, char operand) {
        this.inputs = input;
        this.output = 0;
        this.operand = operand;
    }

    public int[] getInputs() {
        return inputs;
    }

    public int getOutput() {
        return output;
    }

    public void printResult () {
        System.out.println(this.output);
    }

    public void calculate () {
        switch (this.operand) {
            case '+':
                this.output = sum();
                break;
            default:
                this.output = 0;
                break;
        }
    }

    private int sum () {
        int sum = 0;
        for (int input : this.inputs) {
            sum += input;
        }
        return sum;
    }
}
