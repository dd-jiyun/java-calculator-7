package calculator;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DelimiterExtractor {

    public List<String> extract(final String input) {
        Set<String> delimiterSet = getDelimiterSet(input);
        List<String> delimiters = List.copyOf(delimiterSet);

        validateDefaultDelimiters(delimiters);
        return delimiters;
    }

    private Set<String> getDelimiterSet(final String input) {
        Set<String> delimiterSet = new LinkedHashSet<>();

        for (char c : input.toCharArray()) {
            processCharacter(c, delimiterSet);
        }

        return delimiterSet;
    }

    private void validateDefaultDelimiters(final List<String> delimiters) {
        for (String delimiter : delimiters) {
            validateDelimiter(delimiter);
        }
    }

    private void processCharacter(char c, Set<String> delimiterSet) {
        if (Character.isDigit(c)) {
            return;
        }
        delimiterSet.add(String.valueOf(c));
    }

    private void validateDelimiter(final String delimiter) {
        if (!Delimiter.isValidDelimiter(delimiter)) {
            throw new IllegalArgumentException("기본 구분자(,나 :)를 사용해주세요.");
        }
    }
}
