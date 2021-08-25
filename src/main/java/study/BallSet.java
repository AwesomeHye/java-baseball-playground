package study;

import lombok.*;

import java.util.List;

@Getter  @Setter
@NoArgsConstructor @AllArgsConstructor
public class BallSet {
    List<Ball> balls;

    public BallSet(int num1, int num2, int num3) {

    }

    public BallStatus play(Ball ball) {
        return null;
    }

    public BallStatus play(BallSet userBallSet) {
        return null;
    }
}
