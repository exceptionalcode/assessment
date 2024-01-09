import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimpleCalculatorTest {

    @Test
    public void addTest() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(2, calculator.add("2"));
    }
}