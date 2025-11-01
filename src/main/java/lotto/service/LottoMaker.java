package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.Lotto;

public class LottoMaker {
    static final int NUMBER_OF_PICKING = 6;
    static final int LOTTO_NUMBER_RANGE_START = 1;
    static final int LOTTO_NUMBER_RANGE_END = 45;

    public Lotto issueLotto() {
        return new Lotto(pickLottoNumbersByCount(NUMBER_OF_PICKING));
    }

    private List<Integer> pickLottoNumbersByCount(int count) {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_NUMBER_RANGE_START,
                LOTTO_NUMBER_RANGE_END,
                count);
    }
}
