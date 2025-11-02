package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Price;
import lotto.service.LottoPurchaser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoPurchaserTest {
    LottoPurchaser lottoPurchaser = new LottoPurchaser();

    @Test
    @DisplayName("구입금액이 3000원이라면 로또 3개를 발행한다.")
    void checkIssuedLottoNumbers() {
        Price price = new Price(3000);
        List<Lotto> issuedLottos = lottoPurchaser.issueLottoByPrice(price);
        assertThat(issuedLottos.size()).isEqualTo(3);
    }
}