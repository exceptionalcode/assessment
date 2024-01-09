import com.incubyte.assessment.exception.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleCalculatorTest {

    /** passed **/
    @Test
    public void addTwoSimpleNumberTest() throws InvalidInputException {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(3, calculator.add("1,2"));
    }

    /** passed **/
    @Test
    public void emptyStringTest() throws InvalidInputException {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(0, calculator.add(""));
    }

    /** passed **/
    @Test
    public void addTwoNumberWithNewLineTest() throws InvalidInputException {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(3, calculator.add("1,\n2"));
    }

    /** passed **/
    @Test
    public void addTwoNumberWithNewLineAsDelimiterTest() throws InvalidInputException {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }

    /** passed **/
    @Test
    public void addTwoNumberWithNewLineInvalidInputTest() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertThrows(InvalidInputException.class, () -> calculator.add("1,\n"));
    }

    /** passed **/
    @Test
    public void addTwoNumberWithCustomDelimiterTest() throws InvalidInputException {
        SimpleCalculator calculator = new SimpleCalculator();
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    /** passed **/
    @Test
    public void addTwoSimpleNumberWithNegativeTest1() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertThrows(InvalidInputException.class, () -> calculator.add("//;\n-1;-2"));
    }


    /** passed **/
    @Test
    public void addTwoSimpleNumberWithNegativeTest2() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertThrows(InvalidInputException.class, () -> calculator.add("-1,2"));
    }

    /** passed **/
    @Test
    public void addTwoNumberWithNewLineAsDelimiterTest3() throws InvalidInputException {
        SimpleCalculator calculator = new SimpleCalculator();
        assertThrows(InvalidInputException.class, () -> calculator.add("-1\n2,3"));
    }

    /** passed **/
    @Test
    public void addTwoSimpleNumberWithMultipleNegativeTest() {
        SimpleCalculator calculator = new SimpleCalculator();
        assertThrows(InvalidInputException.class, () -> calculator.add("-1,-2"));
    }
}