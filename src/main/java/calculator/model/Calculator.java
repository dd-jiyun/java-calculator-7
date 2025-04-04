package calculator.model;

import java.util.List;

public class Calculator {

    public int add(List<Integer> values) {
        int result = 0;
        for (int value : values) {
            result += value;
        }

        return result;
    }
}
