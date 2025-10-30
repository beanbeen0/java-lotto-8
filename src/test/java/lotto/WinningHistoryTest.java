package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningHistoryTest {

    @Test
    @DisplayName("1등이 2개, 4등이 한개인 경우")
    void test() {
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
}
