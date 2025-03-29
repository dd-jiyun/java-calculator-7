package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @Test
    @DisplayName("문자열을 숫자로 변환한다.")
    void shouldParseNumber_whenString() {
        assertEquals(List.of(1), Parser.parse(List.of("1")));
    }

    @ParameterizedTest
    @DisplayName("문자열을 정수로 변환할 수 없는 경우 예외가 발생한다.")
    @ValueSource(strings = {"a", " ", "1a"})
    void shouldThrowException_whenInvalidNumber(String input) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Parser.parse(List.of(input)));

        assertEquals("숫자만 입력해주세요.", exception.getMessage());
    }

    @Test
    @DisplayName("음수가 입력된 경우 예외가 발생한다.")
    void shouldThrowException_whenNegativeNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Parser.parse(List.of("-1")));

        assertEquals("양수를 입력해주세요.", exception.getMessage());
    }
}
