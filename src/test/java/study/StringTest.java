package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("split 메소드 테스트")
    void split(){
        String str = "1,2";
        String[] actual = str.split(",");
        assertThat(actual).containsExactly("1", "2");

        str = "1";
        actual = str.split(",");
        assertThat(actual).contains("1");
    }

    @Test
    @DisplayName("substring 메소드 테스트")
    void substring() {
        String str = "(1,2)";
        String actual = str.substring(1, str.length() - 1);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("IndexOutOfBoundsException 유발 테스트")
    void charAt() {
        String str = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class).isThrownBy(() -> {
            assertThat(str.charAt(0)).isEqualTo('a');
            assertThat(str.charAt(1)).isEqualTo('b');
            assertThat(str.charAt(3)).isEqualTo('c');
        })
                .withMessage("String index out of range: %s", "3")
                .withMessageContaining("index")
                .withMessageMatching("String index out of range: \\d+");
    }
}
