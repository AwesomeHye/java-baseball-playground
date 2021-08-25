package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BallSetTest {
    @ParameterizedTest
    @MethodSource
    @DisplayName("성공 - 컴퓨터 공 3개 vs. 유저 공 1개 비교")
    public void comBallSet(int num1, int num2, int num3) {
        BallSet comBallSet = new BallSet(num1, num2, num3);
        assertThat(comBallSet.getBalls().size()).isEqualTo(3);
        BallStatus status = comBallSet.play(new Ball(4,0));
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    public static Stream<Arguments> comBallSet() {
        return Stream.of(
                Arguments.of(4, 5, 6),
                Arguments.of(4, 5, 3)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("성공 - 컴퓨터 공 3개 vs. 유저 공 3개 비교")
    public void comNUserBallSet(int comNum1, int comNum2, int comNum3, int userNum1, int userNum2, int userNum3) {
        BallSet comBallSet = new BallSet(comNum1, comNum2, comNum3);
        BallSet userBallSet = new BallSet(userNum1, userNum2, userNum3);
        BallStatus status = comBallSet.play(userBallSet);
        assertThat(status).isEqualTo(BallStatus.STRIKE);
    }

    public static Stream<Arguments> comNUserBallSet() {
        return Stream.of(
                Arguments.of(4, 5, 6, 4, 1, 8)
        );
    }
}
