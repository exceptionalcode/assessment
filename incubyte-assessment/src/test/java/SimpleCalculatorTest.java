import com.incubyte.assessment.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleCalculatorTest {

    @Test
    public void addTwoSimpleNumberTest() throws InvalidInputException {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(3, calculator.add("1,2"));
    }

    @Test
    public void emptyStringTest() throws InvalidInputException {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void addTwoNumberWithNewLineTest() throws InvalidInputException {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(3, calculator.add("1,\n2"));
    }
    @Test
    public void addTwoNumberWithNewLineAsDelimiterTest() throws InvalidInputException {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void addTwoNumberWithNewLineInvalidInputTest() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertThrows(InvalidInputException.class, () -> calculator.add("1,\n"));
    }

    @Test
    public void addTwoNumberWithCustomDelimiterTest() throws InvalidInputException {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }
}