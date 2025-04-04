package calculator.model;

import static calculator.model.DelimiterConstants.DEFAULT_DELIMITER_REGEX;

import java.util.List;
import java.util.stream.Stream;

public enum Delimiter {
    COMMA(",", true),
    COLON(":", true),
    DOUBLE_SLASH("//", false),
    NEW_LINE("\\n", false),
    NUMBER("[0-9]+", false),
    SPACE(" ", false);


    private final String delimiter;
    private final boolean isDefault;

    Delimiter(final String delimiter, final boolean isDefault) {
        this.delimiter = delimiter;
        this.isDefault = isDefault;
    }

    public static List<String> getDefaultDelimiter() {
        return Stream.of(values())
                .filter(Delimiter::isDefault)
                .map(Delimiter::getDelimiter)
                .toList();
    }

    public static boolean isValidDelimiter(String input) {
        return DEFAULT_DELIMITER_REGEX.matcher(input).matches();
    }

    public static boolean isValidCustomDelimiter(String delimiter) {
        return Stream.of(values())
                .noneMatch(d -> d.getDelimiter().equals(delimiter)) && !delimiter.matches(NUMBER.getDelimiter());
    }

    private String getDelimiter() {
        return delimiter;
    }

    private boolean isDefault() {
        return isDefault;
    }
}
