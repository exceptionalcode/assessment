import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleCalculatorTest {

    @Test
    public void addTwoSimpleNumberTest() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void emptyStringTest() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void addTwoNumberWithNewLineTest() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(3, calculator.add("1,\n2"));
    }
}