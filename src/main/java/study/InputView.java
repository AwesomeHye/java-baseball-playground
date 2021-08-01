package study;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

@Slf4j
public class InputView {
    private String input;

    public String getInput() {
        return getInputFromKeyboard("숫자를 입력해 주세요 :");
    }

    public String getContinue() {
        return getInputFromKeyboard("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private String getInputFromKeyboard(String msg) {
        do {
            System.out.println(msg);
            input = new Scanner(System.in).nextLine();
        } while (!NumberUtils.isDigits(input));
        return input;
    }


}
