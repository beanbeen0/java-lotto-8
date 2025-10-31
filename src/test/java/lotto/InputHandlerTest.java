package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    @Test
    @DisplayName("투입 금액이 숫자 형식이 아니면 예외를 반환한다.")
    void checkNumberFormat() {
        String input = " 1";
        assertThatThrownBy(() -> InputHandler.parseToInputPrice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("투입 금액이 음수이면 예외를 반환한다.")
    void checkNegative() {
        String input = "-1000";
        assertThatThrownBy(() -> InputHandler.parseToInputPrice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("투입 금액 1000원 단위가 아니면 음수를 반환한다.")
    void checkMultipleOf1000() {
        String input = "999";
        assertThatThrownBy(() -> InputHandler.parseToInputPrice(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}