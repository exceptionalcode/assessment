import com.incubyte.assessment.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleCalculator {

    public int add(String numbers) throws InvalidInputException {
        if (isNullOrEmpty(numbers)) {
            return 0;
        }
        return addNumbersFromList(numbers);

    }

    private int addNumbersFromList(String numbers) throws InvalidInputException {
        List<Integer> listOfNumbers = convertStringToInteger(numbers);
        int x = 0;
        for (Integer number : listOfNumbers) {
            if (0 != number) {
                x = x + number;
            }
        }
        return x;
    }

    List<Integer> convertStringToInteger(String numbers) throws InvalidInputException {
        return seperateByDelimiter(numbers)
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<String> seperateByDelimiter(String numbers) throws InvalidInputException {
        List<String> curatedSplits = new ArrayList<>();
        String delimiter = ",";
        List<String> splits = Arrays.asList(numbers.split(delimiter));
        for (String split : splits) {
            if (split.contains("\n")) {
                    split = split.substring(split.indexOf("\n") + 1);
               if (split.isEmpty()){
                   throw new InvalidInputException();
               }
            }
            curatedSplits.add(split);
        }
        return curatedSplits;
    }

    private boolean isNullOrEmpty(String numbers) {
        return null == numbers || numbers.isEmpty();
    }
}