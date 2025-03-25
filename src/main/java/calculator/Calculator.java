package calculator;

import java.util.List;

public class Calculator {

    public int addValues(List<Integer> values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }

        return result;
    }
}
