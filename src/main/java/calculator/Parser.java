package calculator;

public class Parser {

    public static int parse(final String s) {
        try {
            int number = Integer.parseInt(s);
            validatePositiveNumber(number);

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해주세요.");
        }
    }

    private static void validatePositiveNumber(final int number) {
        if (number < 0) {
            throw new IllegalArgumentException("양수를 입력해주세요.");
        }
    }
}
