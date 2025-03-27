package calculator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

    @ParameterizedTest
    @DisplayName("명시된 구분자와 일치하는 구분자인지 정상적으로 판별한다.")
    @ValueSource(strings = {",", ":"})
    void shouldReturnTrue_whenValidDelimiter(String delimiter) {
        assertTrue(Delimiter.isValidDelimiter(delimiter));
        assertTrue(Delimiter.isValidDelimiter(delimiter));
    }

    @ParameterizedTest
    @DisplayName("명시된 구분자와 일치하는 구분자가 아니라면 false를 반환한다.")
    @ValueSource(strings = {" ", ";", "a"})
    void shouldReturnFalse_whenInvalidDelimiter(String delimiter) {
        assertFalse(Delimiter.isValidDelimiter(delimiter));
        assertFalse(Delimiter.isValidDelimiter(delimiter));
        assertFalse(Delimiter.isValidDelimiter(delimiter));
    }
}
