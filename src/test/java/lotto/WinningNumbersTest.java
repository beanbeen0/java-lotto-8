package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.LottoNumber;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    @DisplayName("contains 테스트")
    void contains() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = new LottoNumber(3);

        assertThat(winningNumbers.contains(lottoNumber)).isEqualTo(true);
    }

    @Test
    @DisplayName("Equals 테스트")
    void equals() {
        LottoNumber num1 = new LottoNumber(3);
        LottoNumber num2 = new LottoNumber(3);

        assertThat(num1.equals(num2)).isEqualTo(true);
    }
}