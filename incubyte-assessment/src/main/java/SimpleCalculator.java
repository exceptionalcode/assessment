import com.incubyte.assessment.exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleCalculator {

    private static final String NEW_LINE = "\n";

    /**
     * This method is to invoke addition logic, takes string of numbers as input
     *
     * @param numbers
     * @return int
     * @throws InvalidInputException
     */
    public int add(String numbers) throws InvalidInputException {
        if (isNullOrEmpty(numbers)) {
            return 0;
        }
        return addNumbersFromList(numbers);

    }

    /**
     * This method is used to add numbers from the list
     *
     * @param numbers
     * @return int
     * @throws InvalidInputException
     */
    private int addNumbersFromList(String numbers) throws InvalidInputException {
        List<Integer> listOfNumbers = convertStringToInteger(numbers);

        if (listOfNumbers.stream().filter(x -> x < 0).count() > 1) {

            List<Integer> negativeNumbers = listOfNumbers.stream().filter(x -> x < 0).collect(Collectors.toList());
            throw new InvalidInputException("negatives not allowed " + negativeNumbers.stream().map(String::valueOf).collect(Collectors.joining(",")));

        } else if (listOfNumbers.stream().anyMatch(x -> x < 0)) {
            throw new InvalidInputException("negatives not allowed");

        } else {

            return listOfNumbers.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        }
    }

    /**
     * This method is used to convert String to Int
     *
     * @param numbers
     * @return {@link List of Integer}
     * @throws InvalidInputException
     */
    List<Integer> convertStringToInteger(String numbers) throws InvalidInputException {
        return separateByDelimiter(numbers)
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    /**
     * This method is used to prepare spits based on delimiter
     *
     * @param numbers
     * @return {@link List of String}
     * @throws InvalidInputException
     */
    private List<String> separateByDelimiter(String numbers) throws InvalidInputException {
        List<String> curatedSplits = new ArrayList<>();
        numbers = prepareNewLineAsDelimiter(numbers);
        String delimiter = setDefaultDelimiter(numbers);

        List<String> splits = prepareSplitsByDelimiter(numbers, delimiter);
        for (String split : splits) {
            if (split.contains(NEW_LINE)) {
                split = split.substring(split.indexOf(NEW_LINE) + 1);
                if (split.isEmpty()) {
                    throw new InvalidInputException();
                }
            }
            curatedSplits.add(split);
        }
        return curatedSplits;
    }

    /**
     * This method is used to prepare new line char as delimiter when before and after is digit
     *
     * @param numbers
     * @return {@link  String}
     * @throws InvalidInputException
     */
    private String prepareNewLineAsDelimiter(String numbers) throws InvalidInputException {
        if (numbers.contains(NEW_LINE)) {
            String afterNewLine;
            String beforeNewLine;
            try {
                afterNewLine = String.valueOf(numbers.charAt(numbers.indexOf(NEW_LINE) + 1));
                beforeNewLine = String.valueOf(numbers.charAt(numbers.indexOf(NEW_LINE) - 1));
            } catch (Exception exception) {
                throw new InvalidInputException();
            }
            if (!isNullOrEmpty(afterNewLine) && !isNullOrEmpty(beforeNewLine)) {
                if (afterNewLine.matches("\\d+")
                        && beforeNewLine.matches("\\d+")) {
                    return numbers.replace(NEW_LINE, ",");
                }
            }
        }
        return numbers;
    }

    /**
     * This method is used to split the numbers by delimiter provided
     *
     * @param numbers
     * @param delimiter
     * @return {@link  List of String}
     */
    private List<String> prepareSplitsByDelimiter(String numbers, String delimiter) {
        String escape = "//";
        List<String> splits = new ArrayList<>(Arrays.asList(numbers.split(delimiter)));
        splits.remove(escape);
        return splits;
    }

    /**
     * This method is used to set a default delimiter
     *
     * @param numbers {@link  String}
     * @return {@link  String}
     */
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