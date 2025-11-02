package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.LottoRank;
import lotto.service.WinningHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningHistoryTest {

    @Test
    @DisplayName("1등이 2개, 4등이 한개인 경우")
    void createHistory() {
        //given
        List<LottoRank> comparedResults = List.of(LottoRank.FIRST, LottoRank.FIRST, LottoRank.FOURTH);

        //when
        WinningHistory history = WinningHistory.create(comparedResults);

        //then
        assertThat(history.getCountByLottoRank(LottoRank.FIRST)).isEqualTo(2);
        assertThat(history.getCountByLottoRank(LottoRank.SECOND)).isEqualTo(0);
        assertThat(history.getCountByLottoRank(LottoRank.THIRD)).isEqualTo(0);
        assertThat(history.getCountByLottoRank(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(history.getCountByLottoRank(LottoRank.FIFTH)).isEqualTo(0);
        assertThat(history.getCountByLottoRank(LottoRank.MISS)).isEqualTo(0);
    }

    @Test
    @DisplayName("총 상금을 얻는다.")
    void calculateTotalPrizeAmount() {
        //given
        List<LottoRank> comparedResults = List.of(LottoRank.FIRST, LottoRank.FIRST, LottoRank.FOURTH, LottoRank.MISS);
        WinningHistory history = WinningHistory.create(comparedResults);

        //when
        long totalAmount = history.getTotalAmount();

        //then
        assertThat(totalAmount).isEqualTo(4_000_050_000L);
    }

    @Test
    @DisplayName("수익률을 계산한다.")
    void calculateReturnRate() {
        //given
        int inputPrice = 5000;
        List<LottoRank> comparedResults = List.of(LottoRank.FIRST, LottoRank.FIRST);
        WinningHistory history = WinningHistory.create(comparedResults);

        //when
        double returnRate = history.calculateReturnRate(inputPrice);

        //then
        assertThat(returnRate).isEqualTo( (double) 4_000_000_000L /5000 * 100);
    }

    @Test
    @DisplayName("투입금액과 상금이 없을 때 0.0%")
    void calculateReturnRate_zeroCase() {
        //given
        int inputPrice = 0;
        List<LottoRank> comparedResults = List.of();
        WinningHistory history = WinningHistory.create(comparedResults);

        //when
        double returnRate = history.calculateReturnRate(inputPrice);

        //then
        assertThat(returnRate).isEqualTo( 0.0);
    }
}
