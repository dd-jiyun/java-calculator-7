package calculator;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import calculator.model.Delimiter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterTest {

    @ParameterizedTest
    @DisplayName("명시된 구분자와 일치하는 구분자인지 정상적으로 판별한다.")
    @ValueSource(strings = {",", ":"})
    void shouldReturnTrue_whenValidDelimiter(String delimiter) {
        assertTrue(Delimiter.isValidDelimiter(delimiter));
    }

    @ParameterizedTest
    @DisplayName("명시된 구분자와 일치하는 구분자가 아니라면 false를 반환한다.")
    @ValueSource(strings = {";", "a", "@"})
    void shouldReturnFalse_whenInvalidDelimiter(String delimiter) {
        assertFalse(Delimiter.isValidDelimiter(delimiter));
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자로 사용할 수 있는 구분자일 경우 true를 반환한다.")
    @ValueSource(strings = {";", "#", "@", "a", "*"})
    void shouldReturnTrue_whenValidCustomDelimiter(String delimiter) {
        assertTrue(Delimiter.isValidCustomDelimiter(delimiter));
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자로 사용할 수 없는 구분자일 경우 false를 반환한다.")
    @ValueSource(strings = {",", ":", " ", "1", "2"})
    void shouldReturnFalse_whenInvalidCustomDelimiter(String delimiter) {
        assertFalse(Delimiter.isValidCustomDelimiter(delimiter));
    }
}
