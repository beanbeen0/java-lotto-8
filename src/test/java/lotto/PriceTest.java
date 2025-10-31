package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PriceTest {

    @ParameterizedTest
    @DisplayName("구입금액이 1000원 단위가 아니라면 예외를 던진다.")
    @ValueSource(ints = { 999, 1234, 5678})
    void priceShouldBeMultipleOf1000(int price) {
        assertThatThrownBy(() -> new Price(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("구입금액이 음수라면 예외를 던진다.")
    @ValueSource(ints = { -1, -1000})
    void checkPriceGreaterThanZero(int price) {
        assertThatThrownBy(() -> new Price(price))
                .isInstanceOf(IllegalArgumentException.class);
    }
}