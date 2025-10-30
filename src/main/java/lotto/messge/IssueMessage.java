package lotto.messge;

import java.util.List;
import lotto.Lotto;

public class IssueMessage {
    public static String getMessage(List<Lotto> lottos) {
        return Formatter.blocks(formatIssuedCountLine(lottos), formatLottosBlock(lottos));
    }

    private static String formatIssuedCountLine(List<Lotto> lottos) {
        int count = lottos.size();
        return count + "개를 구매했습니다.";
    }

    private static String formatLottosBlock(List<Lotto> lottos) {
        List<String> lines = lottos.stream()
                .map(IssueMessage::formatLottoLine)
                .toList();
        return Formatter.inlines(lines);
    }

    private static String formatLottoLine(Lotto lotto) {
        return lotto.sortedNumbers().toString();
    }
}
