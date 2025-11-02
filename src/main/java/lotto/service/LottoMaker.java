package lotto.service;

import static lotto.constant.Constants.*;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;

public class LottoMaker {

    public Lotto issueLotto() {
        return new Lotto(pickLottoNumbersByCount(LOTTO_NUMBER_COUNT));
    }

    private List<Integer> pickLottoNumbersByCount(int count) {
        return Randoms.pickUniqueNumbersInRange(
                LOTTO_MIN_NUMBER,
                LOTTO_MAX_NUMBER,
                count);
    }
}
