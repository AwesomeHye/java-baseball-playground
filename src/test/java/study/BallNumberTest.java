package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BallNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 9, 10})
    @DisplayName("BallNumber 객체 생성")
    public void createBallNumber(int inputNum) {
        BallNumber ballNumber = new BallNumber(inputNum);
        int number = ballNumber.getNumber();
        assertThat(number).isEqualTo(inputNum);
    }
}
