package calculator.model;

import static calculator.model.DelimiterConstants.CUSTOM_DELIMITER_PREFIX;
import static calculator.model.DelimiterConstants.CUSTOM_DELIMITER_SUFFIX;

import java.util.List;

public class DelimiterExtractor {

    public List<String> extract(final String input) {
        if (isCustomDelimiterFormat(input)) {
            return extractCustomDelimiters(input);
        }

        validateDefaultDelimiter(input);
        return Delimiter.getDefaultDelimiter();
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

    private void validateAllCustomDelimiter(List<String> delimiters) {
        for (String delimiter : delimiters) {
            validateCustomDelimiter(delimiter);
        }
    }

    private void validateCustomDelimiter(final String delimiter) {
        if (!Delimiter.isValidCustomDelimiter(delimiter)) {
            throw new IllegalArgumentException("사용 가능한 커스텀 구분자를 입력해주세요.");
        }
    }

    private void validateDefaultDelimiter(final String input) {
        if (!Delimiter.isValidDelimiter(input)) {
            throw new IllegalArgumentException("기본 구분자(,나 :)를 사용해주세요.");
        }
    }
}
