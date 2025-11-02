package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.messge.IssueMessage;
import lotto.messge.ReportMessage;
import lotto.domain.LottoRank;
import lotto.service.WinningHistory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MessageTest {

    @Test
    @DisplayName("발권 정보 출력 : 1개 일 떄")
    void printIssuedLottos() {
        //given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        //when
        String result = IssueMessage.getMessage(lottos);

        //then
        assertThat(result).isEqualTo("1개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("발권 정보 출력 : 2개 일 때")
    void printIssuedLottos2() {
        //given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );

        //when
        String result = IssueMessage.getMessage(lottos);

        //then
        assertThat(result).isEqualTo("2개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("발권 정보 출력 : 오름차순")
    void printSorter() {
        //given
        List<Lotto> lottos = List.of(new Lotto(List.of(3, 2, 5, 1, 4, 6)));

        //when
        String result = IssueMessage.getMessage(lottos);

        //then
        assertThat(result).isEqualTo("1개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("통계")
    void printReport() {
        //given
        WinningHistory history = WinningHistory.create(List.of(LottoRank.FIFTH, LottoRank.MISS, LottoRank.MISS));
        double rate = history.calculateReturnRate(8000);

        //when
        String result = ReportMessage.getMessage(history, rate);

        //then
        assertThat(result).isEqualTo(
                String.join("\n",
                        "당첨 통계",
                        "---",
                        "3개 일치 (5,000원) - 1개",
                        "4개 일치 (50,000원) - 0개",
                        "5개 일치 (1,500,000원) - 0개",
                        "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                        "6개 일치 (2,000,000,000원) - 0개",
                        "총 수익률은 62.5%입니다."
                )
        );
    }
}
