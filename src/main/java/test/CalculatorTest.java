package test;

import calculator.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private final int[] testInputs = {1, 2, 3};

    @Test()
    public void testInitCalculator() {
        Calculator calculator = new Calculator(this.testInputs, '+');
        int[] inputs = calculator.getInputs();
        assertEquals(1, inputs[0]);
        assertEquals(2, inputs[1]);
        assertEquals(3, inputs[2]);
    }

    @Test()
    public void testSum() {
         Calculator calculator = new Calculator(this.testInputs, '+');
         calculator.calculate();
         assertEquals(6, calculator.getOutput());
    }

    @Test()
    public void testUnknownOperand() {
        Calculator calculator = new Calculator(this.testInputs, 'x');
        calculator.calculate();
        assertEquals(0, calculator.getOutput());
    }
}
