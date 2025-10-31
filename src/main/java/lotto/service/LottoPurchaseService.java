package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.Price;

public class LottoPurchaseService {

    private static final LottoMaker lottoMaker = new LottoMaker();

    private static final int PRICE_PER_LOTTO = 1000;

    public List<Lotto> issueLottoByPrice(Price price) {
        return getLottosByCount(getCountByPrice(price));
    }

//    private void validate(int price) {
//        if (price % PRICE_PER_LOTTO != 0) {
//            throw new IllegalArgumentException("금액은 " + PRICE_PER_LOTTO + "원 단위로 입력해야 합니다.");
//        }
//    }

    private static int getCountByPrice(Price price) {
        return price.value() / PRICE_PER_LOTTO;
    }

    private static List<Lotto> getLottosByCount(int count) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(lottoMaker.issueLotto());
        }
        return lottos;
    }
}
