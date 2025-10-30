package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.service.LottoPurchaseService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoPurchaseServiceTest {
    LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();

    @Test
    @DisplayName("구입금액이 3000원이라면 로또 3개를 발행한다.")
    void checkIssuedLottoNumbers() {
        int price = 3000;
        List<Lotto> issuedLottos = lottoPurchaseService.issueLottoByPrice(price);
        assertThat(issuedLottos.size()).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("구입금액이 1000원 단위가 아니라면 예외를 던진다.")
    @ValueSource(ints = { 999, 1234, 5678})
    void priceShouldBeMultipleOf1000(int price) {
        assertThatThrownBy(() -> lottoPurchaseService.issueLottoByPrice(price))
                .isInstanceOf(IllegalArgumentException.class);
    }
}