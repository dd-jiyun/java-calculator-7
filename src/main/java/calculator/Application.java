package calculator;

import calculator.model.Calculator;
import calculator.model.DelimiterExtractor;
import calculator.model.Parser;
import calculator.model.StringSplitter;
import calculator.view.InputView;
import calculator.view.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        String input = InputView.getInput();

        DelimiterExtractor delimiterExtractor = new DelimiterExtractor();
        List<String> delimiters = delimiterExtractor.extract(input);

        StringSplitter stringSplitter = new StringSplitter();
        List<String> splitResult = stringSplitter.split(input, delimiters);

        List<Integer> parseResult = Parser.parse(splitResult);

        Calculator calculator = new Calculator();
        int result = calculator.add(parseResult);

        OutputView.printResult(result);
    }
}
