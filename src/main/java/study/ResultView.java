package study;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ResultView {
    public void printBall(int ballCnt) {
       System.out.print(ballCnt + "볼 ");
    }

    public void printStrike(int strikeCnt) {
        System.out.print(strikeCnt + "스트라이크");
    }

    public void printNothing() {
        System.out.print("낫싱");
    }

    public void printCongratulation() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printNewline() {
        System.out.println("");
    }
}
