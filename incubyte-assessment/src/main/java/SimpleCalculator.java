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
        return separateByDelimiter(numbers)
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<String> separateByDelimiter(String numbers) throws InvalidInputException {
        List<String> curatedSplits = new ArrayList<>();
        numbers = prepareNewLineAsDelimiter(numbers);
        String delimiter = setDefaultDelimiter(numbers);

        List<String> splits = prepareSplitsByDelimiter(numbers, delimiter);
        for (String split : splits) {
            if (split.contains("\n")) {
                split = split.substring(split.indexOf("\n") + 1);
                if (split.isEmpty()) {
                    throw new InvalidInputException();
                }
            }
            curatedSplits.add(split);
        }
        return curatedSplits;
    }

    private String prepareNewLineAsDelimiter(String numbers) {
        if (!isNullOrEmpty(numbers.substring(numbers.indexOf("\n") + 1)) &&
                numbers.substring(numbers.indexOf("\n") + 1).matches("\\d+")
        && !isNullOrEmpty(numbers.substring(numbers.indexOf("\n") - 1)) &&
                numbers.substring(numbers.indexOf("\n") - 1).matches("\\d+")){

            return numbers.replace("\n", ",");
        }
        return numbers;
    }

    private List<String> prepareSplitsByDelimiter(String numbers, String delimiter) {
        String escape = "//";
        List<String> splits = new ArrayList<>(Arrays.asList(numbers.split(delimiter)));
        splits.remove(escape);
        return splits;
    }

    private String setDefaultDelimiter(String numbers) {
        String defaultDelimiter = ",";
        if (numbers.contains("//")) {
            defaultDelimiter = String.valueOf(numbers.charAt(numbers.lastIndexOf("//") + 2));
        }
        return defaultDelimiter;
    }

    private boolean isNullOrEmpty(String numbers) {
        return null == numbers || numbers.isEmpty();
    }
}