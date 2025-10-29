package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaseServiceTest {
    LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();

    @Test
    @DisplayName("구입금액이 3000원이라면 로또 3개를 발행한다.")
    void checkIssuedLottoNumbers() {
        int price = 3000;
        List<Lotto> issuedLottos = lottoPurchaseService.issueLottoByPrice(price);
        assertThat(issuedLottos.size()).isEqualTo(3);
    }
}