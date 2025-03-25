package calculator;

public enum Delimiter {
    COMMA(","),
    COLON(":");

    private final String delimiter;

    Delimiter(final String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
