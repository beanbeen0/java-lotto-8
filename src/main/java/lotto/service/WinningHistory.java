package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lotto.domain.LottoRank;

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

    public long getTotalAmount() {
        long result = 0;
        for (Entry<LottoRank, Integer> entry : winningCount.entrySet()) {
            result += (long) entry.getKey().prizeAmount() * entry.getValue();
        }
        return result;
    }

    public double calculateReturnRate(int inputPrice) {
        if (inputPrice == 0 && getTotalAmount() == 0) {
            return 0.0;
        }
        return (double) getTotalAmount() / inputPrice * 100;
    }
}
