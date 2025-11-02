package lotto.service;

import static lotto.constant.Constants.*;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Price;

public class LottoPurchaser {

    private static final LottoMaker lottoMaker = new LottoMaker();

    public List<Lotto> issueLottoByPrice(Price price) {
        return getLottosByCount(getCountByPrice(price));
    }

    private static int getCountByPrice(Price price) {
        return price.value() / LOTTO_UNIT_PRICE;
    }

    private static List<Lotto> getLottosByCount(int count) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(lottoMaker.issueLotto());
        }
        return lottos;
    }
}
