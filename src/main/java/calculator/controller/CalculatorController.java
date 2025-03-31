package calculator.controller;

import calculator.model.Calculator;
import calculator.model.DelimiterExtractor;
import calculator.model.Parser;
import calculator.model.StringSplitter;
import calculator.view.InputView;
import calculator.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class CalculatorController {

    private final DelimiterExtractor delimiterExtractor;
    private final StringSplitter stringSplitter;
    private final Calculator calculator;

    public CalculatorController(final DelimiterExtractor delimiterExtractor,
                                final StringSplitter stringSplitter,
                                final Calculator calculator) {
        this.delimiterExtractor = delimiterExtractor;
        this.stringSplitter = stringSplitter;
        this.calculator = calculator;
    }

    public void run() {
        String input = InputView.getInput();
        if (isCheckedEmptyOrNull(input)) {
            return;
        }

        List<String> delimiters = delimiterExtractor.extract(input);
        List<String> numbers = stringSplitter.split(input, delimiters);
        List<Integer> parsedNumbers = Parser.parse(numbers);

        int result = calculator.add(parsedNumbers);
        OutputView.printResult(result);
        Console.close();
    }

    private boolean isCheckedEmptyOrNull(final String input) {
        if (input == null || input.isBlank()) {
            OutputView.printResult(0);
            return true;
        }

        return false;
    }
}
