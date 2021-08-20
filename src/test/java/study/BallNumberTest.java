package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class BallNumberTest {
    @ParameterizedTest
    @CsvSource(value = {"1:true", "9:true", "0:false", "10:false",}, delimiter = ':')
    @DisplayName("숫자가 1~9인지 테스트")
    public void isBallNumber1To9(int number, boolean result) {
        assertThat(ValidationUtils.isValidNumber(number)).isEqualTo(result);
    }
}
