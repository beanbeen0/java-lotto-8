package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoMaker {
    static final int NUMBER_OF_PICKING = 6;
    static final int LOTTO_NUMBER_RANGE_START = 1;
    static final int LOTTO_NUMBER_RANGE_END = 45;

    public Lotto issueLotto() {
        return new Lotto(pickLottoNumbersByCount(NUMBER_OF_PICKING));
    }

    private List<Integer> pickLottoNumbersByCount(int count) {
        Set<Integer> notDuplicatedNumbers = new HashSet<>();
        while (notDuplicatedNumbers.size() < count) {
            notDuplicatedNumbers.add(pickRandomLottoNumber());
        }
        return notDuplicatedNumbers.stream().toList();
    }

    private int pickRandomLottoNumber() {
        return Randoms.pickNumberInRange(LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END);
    }
}
