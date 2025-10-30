package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningHistory {
    private final Map<LottoRank, Integer> winningCount;

    private WinningHistory() {
        this.winningCount = new EnumMap<>(LottoRank.class);
    }

    public static WinningHistory create(List<LottoRank> results) {
        WinningHistory tmp = new WinningHistory();
        results.forEach(tmp::addWinningCount);
        return tmp;
    }

    public int getCountByLottoRank(LottoRank rank) {
        return winningCount.getOrDefault(rank, 0);
    }

    public void addWinningCount(LottoRank rank) {
        winningCount.put(rank, getCountByLottoRank(rank) + 1);
    }
}
