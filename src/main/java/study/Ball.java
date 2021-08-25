package study;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Ball {
    private int number;
    private int position;

    public BallStatus play(Ball userBall) {
        return BallStatus.NOTHING;
    }
}
