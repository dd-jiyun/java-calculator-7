package calculator.model;

import static calculator.model.CustomDelimiterFormat.CUSTOM_DELIMITER_PREFIX;
import static calculator.model.CustomDelimiterFormat.CUSTOM_DELIMITER_SUFFIX;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringSplitter {

    public List<String> split(String input, final List<String> delimiters) {
        input = preprocessingCustomDelimiter(input);

        String regex = getRegex(delimiters);
        String[] splitResult = input.split(regex);

        return List.of(splitResult);
    }

    private String preprocessingCustomDelimiter(String input) {
        if (input.startsWith(CUSTOM_DELIMITER_PREFIX) && input.contains(CUSTOM_DELIMITER_SUFFIX)) {
            input = input.substring(input.indexOf(CUSTOM_DELIMITER_SUFFIX) + 2);
        }

        return input;
    }

    private String getRegex(final List<String> delimiters) {
        return delimiters.stream()
                .map(Pattern::quote)
                .collect(Collectors.joining("|"));
    }
}
