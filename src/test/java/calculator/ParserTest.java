package calculator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {

    @Test
    @DisplayName("문자열을 숫자로 변환한다.")
    void shouldParseNumber_whenString() {
        int result = Parser.parse("1");

        assertEquals(1, result);
    }

    @Test
    @DisplayName("문자열을 숫자로 변환할 수 없는 경우 예외가 발생한다.")
    void shouldThrowsException_whenNotNumber() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Parser.parse("a"));

        assertEquals("숫자로 변환할 수 없는 값이 입력되었습니다.", exception.getMessage());
    }
}
