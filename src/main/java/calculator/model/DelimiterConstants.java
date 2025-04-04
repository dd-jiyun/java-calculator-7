package calculator.model;

import java.util.regex.Pattern;

public class DelimiterConstants {
    public static final Pattern DEFAULT_DELIMITER_REGEX = Pattern.compile("^[0-9,:]+$");
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String CUSTOM_DELIMITER_SUFFIX = "\\n";
}
