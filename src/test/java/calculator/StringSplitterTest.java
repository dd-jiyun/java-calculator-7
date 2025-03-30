package calculator;

import static org.junit.jupiter.api.Assertions.*;

import calculator.model.DelimiterExtractor;
import calculator.model.StringSplitter;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringSplitterTest {

    @ParameterizedTest
    @DisplayName("입력받은 구분자로 문자열을 나눈다.")
    @ValueSource(strings = {"1,2,3", "1:2:3", "1,2:3"})
    void shouldSplitString_whenGivingDelimiters(String input) {
        //given
        StringSplitter splitter = new StringSplitter();
        DelimiterExtractor extractor = new DelimiterExtractor();

        //when
        List<String> delimiters = extractor.extract(input);
        List<String> result = splitter.split(input, delimiters);

        //then
        assertEquals(List.of("1", "2", "3"), result);
    }

    @ParameterizedTest
    @DisplayName("입력받은 커스텀 구분자로 문자열을 나눈다.")
    @ValueSource(strings = {"//;\\n1;2;3", "//*\\n1*2*3", "//***\\n1***2***3"})
    void shouldSplitString_whenGivingCustomDelimiters(String input) {
        //given
        StringSplitter splitter = new StringSplitter();
        DelimiterExtractor extractor = new DelimiterExtractor();

        //when
        List<String> delimiters = extractor.extract(input);
        List<String> result = splitter.split(input, delimiters);

        //then
        assertEquals(List.of("1", "2", "3"), result);
    }
}
