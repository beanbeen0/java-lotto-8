package lotto.messge;

import java.util.stream.Collectors;
import lotto.domain.LottoRank;
import lotto.service.WinningHistory;

public class ReportMessage {

    public static String getMessage(WinningHistory history, double profitRate) {
        String header = Formatter.blocks("당첨 통계", "---");

        String body = LottoRank.getWinningRanks().stream()
                .map(rank -> Formatter.spans(
                        rank.description(),
                        String.format("(%s원)", formatPrize(rank.prizeAmount())),
                        "-",
                        history.getCountByLottoRank(rank) + "개"
                ))
                .collect(Collectors.joining("\n"));

        String footer = String.format("총 수익률은 %.1f%%입니다.", profitRate);

        return Formatter.blocks(header, body, footer);
    }

    private static String formatPrize(int prize) {
        return String.format("%,d", prize);
    }
}
