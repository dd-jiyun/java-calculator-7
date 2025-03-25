package calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}
