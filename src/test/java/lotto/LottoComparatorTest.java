package lotto;


import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.service.LottoComparator;
import lotto.service.LottoRank;
import lotto.service.Standard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoComparatorTest {

    LottoComparator lottoComparator = new LottoComparator();

    @Test
    @DisplayName("6개가 일치하면 1등이다.")
    void testFirstPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        Standard standard = new Standard(winningNumbers, bonusNumber);

        assertThat(lottoComparator.compare(standard, lotto))
                .isEqualTo(LottoRank.FIRST);
    }

    @Test
    @DisplayName("5개가 일치하고, 보너스번호가 일치하면, 2등이다.")
    void testSecondPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        Standard standard = new Standard(winningNumbers, bonusNumber);

        assertThat(lottoComparator.compare(standard, lotto))
                .isEqualTo(LottoRank.SECOND);
    }

    @Test
    @DisplayName("5개가 일치하고, 보너스번호가 불일치하면, 3등이다.")
    void testThirdPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 8));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        Standard standard = new Standard(winningNumbers, bonusNumber);

        assertThat(lottoComparator.compare(standard, lotto))
                .isEqualTo(LottoRank.THIRD);
    }

    @Test
    @DisplayName("4개가 일치하면 4등이다.")
    void testFourthPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        Standard standard = new Standard(winningNumbers, bonusNumber);

        assertThat(lottoComparator.compare(standard, lotto))
                .isEqualTo(LottoRank.FOURTH);
    }
    @Test
    @DisplayName("3개가 일치하면 5등이다.")
    void testFifthPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 8, 9, 10));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        Standard standard = new Standard(winningNumbers, bonusNumber);

        assertThat(lottoComparator.compare(standard, lotto))
                .isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("2개가 일치하면 낙첨이다.")
    void testMissPrize() {
        Lotto lotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        Standard standard = new Standard(winningNumbers, bonusNumber);

        assertThat(lottoComparator.compare(standard, lotto))
                .isEqualTo(LottoRank.MISS);
    }

    @Test
    @DisplayName("보너스 번호 일치는 당첨 번호 갯수에 포함되지 않는다.")
    void test() {
        Lotto lotto = new Lotto(List.of(1, 2, 8, 9, 10, 11));
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = new LottoNumber(7);
        Standard standard = new Standard(winningNumbers, bonusNumber);

        assertThat(lottoComparator.compare(standard, lotto))
                .isEqualTo(LottoRank.MISS);
    }

}