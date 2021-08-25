package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {
    @ParameterizedTest
    @MethodSource
    @DisplayName("성공 - Ball 생성")
    public void createBall(int userNum, int userNumPosition) {
        Ball userBall = new Ball(userNum, userNumPosition);
        assertThat(userBall.getNumber()).isEqualTo(userNum);
        assertThat(userBall.getPosition()).isEqualTo(userNumPosition);
    }

    public static Stream<Arguments> createBall() {
        return Stream.of(
                Arguments.of(2, 0),
                Arguments.of(3, 1),
                Arguments.of(4, 2)
                );
    }


    @ParameterizedTest
    @MethodSource
    @DisplayName("성공 - 컴퓨터 공 1개 vs. 유저 공 1개 nothing 테스트")
    public void nothing(int userNum, int userNumPosition, int comNum, int comNumPosition) {
        Ball userBall = new Ball(userNum, userNumPosition);
        Ball comBall = new Ball(comNum, comNumPosition);

        assertThat(comBall.play(userBall)).isEqualTo(BallStatus.NOTHING);
    }

    public static Stream<Arguments> nothing() {
        return Stream.of(
                Arguments.of(1, 0, 2, 0),
                Arguments.of(1, 0, 3, 1),
                Arguments.of(1, 0, 4, 2)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("성공 - 컴퓨터 공 1개 vs. 유저 공 1개 ball 테스트")
    public void ball(int userNum, int userNumPosition, int comNum, int comNumPosition) {
        Ball userBall = new Ball(userNum, userNumPosition);
        Ball comBall = new Ball(comNum, comNumPosition);

        assertThat(comBall.play(userBall)).isEqualTo(BallStatus.BALL);
    }

    public static Stream<Arguments> ball() {
        return Stream.of(
                Arguments.of(4, 0, 4, 2),
                Arguments.of(5, 1, 5, 0),
                Arguments.of(6, 2, 6, 1)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("성공 - 컴퓨터 공 1개 vs. 유저 공 1개 strike 테스트")
    public void strike(int userNum, int userNumPosition, int comNum, int comNumPosition) {
        Ball userBall = new Ball(userNum, userNumPosition);
        Ball comBall = new Ball(comNum, comNumPosition);

        assertThat(comBall.play(userBall)).isEqualTo(BallStatus.STRIKE);
    }

    public static Stream<Arguments> strike() {
        return Stream.of(
                Arguments.of(7, 0, 1, 0),
                Arguments.of(8, 1, 1, 1),
                Arguments.of(9, 2, 1, 2)
        );
    }
}
