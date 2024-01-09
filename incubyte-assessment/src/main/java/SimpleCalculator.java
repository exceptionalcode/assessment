public class SimpleCalculator {

    public int add(String numbers) {
        if (isNullOrEmpty(numbers)) {
            return 0;
        }
        return 1;
    }

    private boolean isNullOrEmpty(String numbers) {
        return null == numbers || numbers.isEmpty();
    }
}