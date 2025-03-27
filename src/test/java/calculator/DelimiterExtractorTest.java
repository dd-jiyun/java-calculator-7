package calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class DelimiterExtractorTest {

    @ParameterizedTest
    @DisplayName("문자열에서 기본 구분자를 추출한다.")
    @CsvSource(value = {
            "1,2,3 | ,",
            "1:2:3 | :",
            "1,2:3 | ,:"
    }, delimiter = '|')
    void shouldExtractDelimiter_whenGivenString(String input, String expected) {
        //given
        DelimiterExtractor extractor = new DelimiterExtractor();

        //when
        List<String> result = extractor.extract(input);

        //then
        assertEquals(List.of(expected.split("")), result);
    }

    @ParameterizedTest
    @DisplayName("기본 구분자에 속하지 않는 구분자를 사용할 경우 예외가 발생한다.")
    @ValueSource(strings = {"1,2;3", "1;2;3","1:2#3"})
    void shouldReturnEmptyList_whenNotDefaultDelimiter(String input) {
        //given
        DelimiterExtractor extractor = new DelimiterExtractor();

        //when
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> extractor.extract(input));

        //then
        assertEquals("기본 구분자(,나 :)를 사용해주세요.", exception.getMessage());
    }
}
