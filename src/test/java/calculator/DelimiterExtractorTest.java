package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import calculator.model.DelimiterExtractor;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterExtractorTest {

    @ParameterizedTest
    @DisplayName("문자열에서 기본 구분자를 추출한다.")
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    void shouldExtractDelimiter_whenGivenString(String input) {
        //given
        DelimiterExtractor extractor = new DelimiterExtractor();

        //when
        List<String> result = extractor.extract(input);

        //then
        assertEquals(List.of(",", ":"), result);
    }

    @ParameterizedTest
    @DisplayName("기본 구분자에 속하지 않는 구분자를 사용할 경우 예외가 발생한다.")
    @ValueSource(strings = {"1,2;3", "1;2;3", "1:2#3"})
    void shouldReturnEmptyList_whenNotDefaultDelimiter(String input) {
        //given
        DelimiterExtractor extractor = new DelimiterExtractor();

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> extractor.extract(input));

        //then
        assertEquals("기본 구분자(,나 :)를 사용해주세요.", exception.getMessage());
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자의 형식이 올바르지 않을 경우 예외가 발생한다.")
    @ValueSource(strings = {"//;1;2;3", "#\\n1#2#3", "/;\\n1;2;3"})
    void shouldThrowException_whenInvalidCustomDelimiterFormat(String input) {
        //given
        DelimiterExtractor extractor = new DelimiterExtractor();

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> extractor.extract(input));

        //then
        assertEquals("커스텀 구분자 형식에 맞게 입력해주세요.", exception.getMessage());
    }

    @Test
    @DisplayName("커스텀 구분자 형식에서 구분자가 비어있을 경우 예외가 발생한다.")
    void shouldThrowException_whenEmptyCustomDelimiterFormat() {
        //given
        DelimiterExtractor extractor = new DelimiterExtractor();

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> extractor.extract("//\\n1;2;3"));

        //then
        assertEquals("커스텀 구분자를 입력해주세요.", exception.getMessage());
    }

    @Test
    @DisplayName("문자열에서 커스텀 구분자를 추출한다.")
    void shouldExtractCustomDelimiter_whenGivingString() {
        //given
        DelimiterExtractor extractor = new DelimiterExtractor();

        //when
        List<String> result = extractor.extract("//;\\n1;2;3");

        //then
        assertEquals(List.of(";"), result);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자로 사용할 수 없는 구분자를 입력했을 경우 예외가 발생한다.")
    @ValueSource(strings = {"//1\\n112131", "//:\\n1:2:3", "////\\n1//2//3"})
    void shouldThrowException_whenInvalidCustomDelimiter(String input) {
        //given
        DelimiterExtractor extractor = new DelimiterExtractor();

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> extractor.extract(input));

        //then
        assertEquals("사용 가능한 커스텀 구분자를 입력해주세요.", exception.getMessage());
    }
}
