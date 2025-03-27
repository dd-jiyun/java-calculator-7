package calculator;

import java.util.stream.Stream;

public enum Delimiter {
    COMMA(","),
    COLON(":");

    private final String delimiter;

    Delimiter(final String delimiter) {
        this.delimiter = delimiter;
    }

    public static boolean isValidDelimiter(String delimiter) {
        return Stream.of(values())
                .anyMatch(d -> d.getDelimiter().equals(delimiter));
    }

    public String getDelimiter() {
        return delimiter;
    }
}
