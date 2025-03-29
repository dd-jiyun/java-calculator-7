package calculator;

import java.util.List;

public class Parser {

    public static List<Integer> parse(final List<String> input) {
        try {
            List<Integer> numbers = getNumbers(input);
            for (int number : numbers) {
                validatePositiveNumber(number);
            }

            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private static List<Integer> getNumbers(final List<String> input) {
        return input.stream()
                .mapToInt(Integer::parseInt)
                .boxed()
                .toList();
    }

    private static void validatePositiveNumber(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
    }
}
