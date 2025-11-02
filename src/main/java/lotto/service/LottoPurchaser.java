package lotto.service;

import static lotto.Constants.*;

import java.util.ArrayList;
import java.util.List;
import lotto.Constants;
import lotto.Lotto;
import lotto.Price;

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
