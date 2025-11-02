package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoRank {

    MISS("2개 이하 일치", 0),
    FIFTH("3개 일치", 5000),
    FOURTH("4개 일치", 50000),
    THIRD("5개 일치", 1500000),
    SECOND("5개 일치, 보너스 볼 일치", 30000000),
    FIRST("6개 일치", 2000000000);

    private final String description;
    private final int prizeAmount;

    LottoRank(String description, int prizeAmount) {
        this.description = description;
        this.prizeAmount = prizeAmount;
    }

    public int prizeAmount() {
        return prizeAmount;
    }

    public String description() {
        return description;
    }

    public static List<LottoRank> getWinningRanks() {
        return Arrays.stream(values())
                .filter(rank -> rank != MISS)
                .toList();
    }

    public static LottoRank getRank(int matchedGeneralCount, boolean matchedBonus) {
        if (matchedGeneralCount == 6)
            return LottoRank.FIRST;
        if (matchedGeneralCount == 5 && matchedBonus)
            return LottoRank.SECOND;
        if (matchedGeneralCount == 5)
            return LottoRank.THIRD;
        if (matchedGeneralCount == 4)
            return LottoRank.FOURTH;
        if (matchedGeneralCount == 3)
            return LottoRank.FIFTH;
        return LottoRank.MISS;
    }
}
