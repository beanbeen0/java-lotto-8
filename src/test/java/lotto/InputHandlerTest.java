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

    @Test
    @DisplayName("당첨 로또 번호 양식 검사")
    void checkLottoNumbersFormat() {
        String input = "";
        assertThatThrownBy(() -> InputHandler.parseToLottoNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또 숫자들의 범위(1~45)를 벗어나면 예외를 던진다.")
    void checkLottoNumbersRange() {
        String input = "-1,5,45,4,5,6";
        assertThatThrownBy(() -> InputHandler.parseToLottoNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또 번호가 6개가 아니며 예외를 던진다.")
    void checkNumberOfLottoNumbers() {
        String input = "1,2,3,4,5";
        assertThatThrownBy(() -> InputHandler.parseToLottoNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또 번호가 중복되면 예외를 던진다.")
    void checkDuplicatedLottoNumbers() {
        String input = "1,1,3,4,5,6";
        assertThatThrownBy(() -> InputHandler.parseToLottoNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}