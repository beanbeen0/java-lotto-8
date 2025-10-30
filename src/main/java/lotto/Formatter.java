package lotto;

import java.util.List;

public class Formatter {

    private static String blocks(String... blocks) {
        return String.join("\n", blocks);
    }

    private static String inlines(List<String> inlines) {
        return String.join("\n", inlines);
    }

    public static String getIssuedMessage(List<Lotto> lottos) {
        return blocks(formatIssuedCountLine(lottos), formatLottosBlock(lottos));
    }

    private static String formatIssuedCountLine(List<Lotto> lottos) {
        int count = lottos.size();
        return count + "개를 구매했습니다.";
    }

    private static String formatLottosBlock(List<Lotto> lottos) {
        List<String> lines = lottos.stream()
                .map(Formatter::formatLottoLine)
                .toList();
        return inlines(lines);
    }

    private static String formatLottoLine(Lotto lotto) {
        return lotto.sortedNumbers().toString();
    }
}
