package calculator;


import static org.junit.jupiter.api.Assertions.assertEquals;

import calculator.model.Calculator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    @DisplayName("리스트의 값을 더한다.")
    void shouldReturnAdd_whenValues() {
        Calculator calculator = new Calculator();
        int result = calculator.add(List.of(1, 2, 3, 4, 5));

        assertEquals(15, result);
    }

    @Test
    @DisplayName("리스트에 값이 없을 때 0을 반환한다.")
    void shouldReturnZero_whenEmptyValue() {
        Calculator calculator = new Calculator();
        int result = calculator.add(List.of());

        assertEquals(0, result);
    }
}
