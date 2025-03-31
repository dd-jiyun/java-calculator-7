package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.model.DelimiterExtractor;
import calculator.model.StringSplitter;

public class Application {
    public static void main(String[] args) {

        CalculatorController calculatorController = new CalculatorController(
                new DelimiterExtractor(),
                new StringSplitter(),
                new Calculator()
        );
        calculatorController.run();
    }
}
