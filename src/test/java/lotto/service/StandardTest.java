package lotto.service;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.LottoNumber;
import lotto.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StandardTest {

    @Test
    @DisplayName("당첨 번호들과 보너스 번호들이 중복되면 예외를 던진다.")
    void checkNoDuplicatedBonusNumberWithWinningNumbers() {
        LottoNumber bonus = new LottoNumber(3);
        WinningNumbers winning = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new Standard(winning, bonus))
                .isInstanceOf(IllegalArgumentException.class);
    }
}