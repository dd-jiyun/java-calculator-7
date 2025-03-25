package calculator;

import java.util.List;
import java.util.stream.Stream;

public class DelimiterExtractor {
    public List<String> extract(String input) {
        return Stream.of(Delimiter.values())
                .map(Delimiter::getDelimiter)
                .filter(input::contains)
                .toList();
    }
}
