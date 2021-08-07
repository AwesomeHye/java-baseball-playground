package study;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class NumberBaseballGameTest {
    private Integer DIGIT_NUMBER = 3;
    private String continueValue;
    private String answer, input;
    private int ballCnt, strikeCnt;
    private InputView inputView;
    private ResultView resultView;
    private NumberBaseballGame numberBaseballGame;
    @BeforeAll
    public void initClass() {
        this.numberBaseballGame = new NumberBaseballGame();
    }


}