package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static final String START_MESSAGE = "덧셈할 문자열을 입력해주세요.";
    public static final String USAGE_GUIDE = """
            [사용 안내]
            기본 구분자 => ,(쉼표)와 :(콜론)만 사용 가능합니다.
            커스텀 구분자 => //{구분자}\\n 형식을 사용해 선언할 수 있습니다.
            """;

    private InputView() {
    }

    public static String getInput() {
        System.out.println(START_MESSAGE);
        System.out.println(USAGE_GUIDE);
        return Console.readLine();
    }
}
