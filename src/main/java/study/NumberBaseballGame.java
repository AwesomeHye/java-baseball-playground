package study;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;

@Slf4j
public class NumberBaseballGame {
    private Integer DIGIT_NUMBER = 3;
    private String continueValue;
    private String answer, input;
    private int ballCnt, strikeCnt;
    private InputView inputView;
    private ResultView resultView;

    public NumberBaseballGame() {
        this.continueValue = "1";
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    /**
     * 게임 시작
     */
    public void start() {
        do {
            playGame();
        } while (isStart());
    }

    /**
     * 게임 진행
     */
    private void playGame() {
        generateAnswer();

        do {
            input = inputView.getInput();
            compare();
            printCompareResult();
        } while (!isAnswer());

        askReplay();
    }


    /**
     * 게임 시작 여부 판단
     * @return
     */
    private boolean isStart() {
        return continueValue.equals("1");
    }


    /**
     * answer, input 생성하기
     */
    private void generateAnswer() {
        answer = getRandomAnswer();
        log.info("answer: {}", answer);
    }

    /**
     * 랜덤 답 얻기
     * @return
     */
    private String getRandomAnswer() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        do {
            int randomNumber = random.nextInt(10);
            if(isAnswerContainNumber(sb.toString(), String.valueOf(randomNumber))) continue;
            sb.append(randomNumber);
        } while(sb.length() < 3);

        return sb.toString();
    }

    /**
     * answer에 숫자 포함 여부
     * @param answer
     * @param numberString
     * @return
     */
    private boolean isAnswerContainNumber(String answer, String numberString) {
        return answer.contains(numberString);
    }

    /**
     * 스트라이크, 볼 카운트 연산하기
     */
    private void compare() {
        strikeCnt = 0;
        ballCnt = 0;

        for (int i = 0; i < DIGIT_NUMBER; i++) {
            boolean isStrikeNumber = isStrike(i);
            if(isStrikeNumber) {
                strikeCnt++;
            }
            if (isBall(i, isStrikeNumber)) {
                ballCnt++;
            }
        }
    }


    /**
     * answer, input 에서 인덱스에 해당하는 숫자가 스트라이크인지 여부
     * @param i 인덱스
     * @return
     */
    private boolean isStrike(int i) {
        return answer.charAt(i) == input.charAt(i);
    }

    /**
     * answer, input 에서 인덱스에 해당하는 숫자가 볼인지 여부
     * @param i 인덱스
     * @param isStrikeNumber 스트라이크 여부
     * @return
     */
    private boolean isBall(int i, boolean isStrikeNumber) {
        if(isStrikeNumber)
            return false;

        return isAnswerContainNumber(answer, Character.toString(input.charAt(i)));
    }


    /**
     * 스트라이크, 볼 카운트 비교 결과 출력하기
     */
    private void printCompareResult() {
        if(ballCnt == 0 && strikeCnt == 0)
            resultView.printNothing();

        if(ballCnt > 0)
            resultView.printBall(ballCnt);

        if(strikeCnt > 0)
            resultView.printStrike(strikeCnt);

        resultView.printNewline();
    }

    /**
     * 정답 맞췄는지 여부
     * @return
     */
    private boolean isAnswer() {
        return strikeCnt == DIGIT_NUMBER;
    }

    /**
     * 게임 재시작 여부 묻기
     */
    private void askReplay() {
        resultView.printCongratulation();
        continueValue = inputView.getContinue();
    }

}
