package calculator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {

    @Test
    @DisplayName("값이 입력되지 않았을 때 0이 반환된다.")
    void shouldReturnZero_whenEmptyInput() {
        assertSimpleTest(() -> {
            run(" ");
            assertThat(output()).contains("결과 : 0");
        });
    }

    @Test
    @DisplayName("올바른 값을 하나만 입력했을 경우 결과가 반환된다.")
    void shouldReturnValue_whenSingleInput() {
        assertSimpleTest(() -> {
            run("3");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @ParameterizedTest
    @DisplayName("기본 구분자를 사용하였을 때 정상적으로 결과가 반환된다.")
    @ValueSource(strings = {"1,2:3", "1,2,3", "1:2:3"})
    void shouldReturn_whenUsingDefaultDelimiter(String input) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 6");
        });
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자를 사용하였을 때 정상적으로 결과가 반환된다.")
    @ValueSource(strings = {"//;\\n1;2;3", "//#\\n1#2#3"})
    void shouldReturn_whenUsingCustomDelimiter(String input) {
        assertSimpleTest(() -> {
            run(input);
            assertThat(output()).contains("결과 : 6");
        });
    }

    @ParameterizedTest
    @DisplayName("기본 구분자를 올바르게 입력하지 않았을 경우 예외가 발생한다.")
    @ValueSource(strings = {"1:a:3", "-1,2:3", "-1,2,3"})
    void shouldThrowException_whenInvalidInput(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자를 올바르게 입력하지 않았을 경우 예외가 발생한다.")
    @ValueSource(strings = {"//;1;2;3", "#\\n1#2#3", "/;\\n1;2;3", "//\\n1;2;3"})
    void shouldThrowException_whenInvalidCustomDelimiterFormat(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
