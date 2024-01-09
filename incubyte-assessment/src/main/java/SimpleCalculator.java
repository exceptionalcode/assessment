import java.util.Arrays;
import java.util.List;

public class SimpleCalculator {

    public int add(String numbers) {
        if (isNullOrEmpty(numbers)) {
            return 0;
        }
        List<String> listOfNumbers = Arrays.asList(numbers.split(","));
        return addNumbersFromList(listOfNumbers);

    }

    private int addNumbersFromList(List<String> listOfNumbers) {
        int x = 0;
        for (String numbers : listOfNumbers) {
            int number = Integer.parseInt(numbers);
            if (0 != number) {
                x = x + number;
            }
        }
        return x;
    }

    private boolean isNullOrEmpty(String numbers) {
        return null == numbers || numbers.isEmpty();
    }
}