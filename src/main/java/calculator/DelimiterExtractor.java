package calculator;

import static calculator.CustomDelimiterFormat.CUSTOM_DELIMITER_PREFIX;
import static calculator.CustomDelimiterFormat.CUSTOM_DELIMITER_SUFFIX;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DelimiterExtractor {

    public List<String> extract(final String input) {
        if (isCustomDelimiterFormat(input)) {
            return extractCustomDelimiters(input);
        }

        return extractDefaultDelimiters(input);
    }

    private boolean isCustomDelimiterFormat(String input) {
        return input.startsWith(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX);
    }

    private List<String> extractCustomDelimiters(String input) {
        List<String> delimiters = List.of(
                input.substring(CUSTOM_DELIMITER_PREFIX.length(), input.indexOf(CUSTOM_DELIMITER_SUFFIX)));
        validateAllCustomDelimiter(delimiters);

        return delimiters;
    }

    private List<String> extractDefaultDelimiters(String input) {
        Set<String> delimiterSet = getDelimiterSet(input);
        List<String> delimiters = List.copyOf(delimiterSet);
        validateAllDefaultDelimiter(delimiters);

        return delimiters;
    }

    private Set<String> getDelimiterSet(final String input) {
        Set<String> delimiterSet = new LinkedHashSet<>();

        for (char c : input.toCharArray()) {
            processCharacter(c, delimiterSet);
        }

        return delimiterSet;
    }

    private void processCharacter(char c, Set<String> delimiterSet) {
        if (Character.isDigit(c)) {
            return;
        }
        delimiterSet.add(String.valueOf(c));
    }

    private void validateAllCustomDelimiter(List<String> delimiters) {
        for (String delimiter : delimiters) {
            validateCustomDelimiter(delimiter);
        }
    }

    private static void validateCustomDelimiter(final String delimiter) {
        if (!Delimiter.isValidCustomDelimiter(delimiter)) {
            throw new IllegalArgumentException("사용 가능한 커스텀 구분자를 입력해주세요.");
        }
    }

    private void validateAllDefaultDelimiter(final List<String> delimiters) {
        for (String delimiter : delimiters) {
            validateDefaultDelimiter(delimiter);
        }
    }

    private void validateDefaultDelimiter(final String delimiter) {
        if (!Delimiter.isValidDelimiter(delimiter)) {
            throw new IllegalArgumentException("기본 구분자(,나 :)를 사용해주세요.");
        }
    }
}
