package calculator.model;

import java.util.stream.Stream;

public enum Delimiter {
    COMMA(",", true),
    COLON(":", true),
    DOUBLE_SLASH("//", false),
    NEW_LINE("\\n", false),
    NUMBER("[0-9]+", false),
    SPACE(" ", false)
    ;

    private final String delimiter;
    private final boolean isDefault;

    Delimiter(final String delimiter, final boolean isDefault) {
        this.delimiter = delimiter;
        this.isDefault = isDefault;
    }

    public static boolean isValidDelimiter(String delimiter) {
        return Stream.of(values())
                .filter(d -> d.isDefault)
                .anyMatch(d -> d.getDelimiter().equals(delimiter));
    }

    public static boolean isValidCustomDelimiter(String delimiter) {
        return Stream.of(values())
                .noneMatch(d -> d.getDelimiter().equals(delimiter)) && !delimiter.matches(NUMBER.getDelimiter());
    }

    public String getDelimiter() {
        return delimiter;
    }
}
