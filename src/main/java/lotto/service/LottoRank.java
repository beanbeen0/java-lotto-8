package lotto.service;

public enum LottoRank {

    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    MISS(0);

    private final int prizeAmount;

    LottoRank(int prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public int prizeAmount() {
        return prizeAmount;
    }
}
