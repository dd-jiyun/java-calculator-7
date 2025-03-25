package calculator;

public class Parser {

    public static int parse(final String s) {
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 값이 입력되었습니다.");
        }
    }
}
