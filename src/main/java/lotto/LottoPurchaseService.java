package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPurchaseService {

    private static final LottoMaker lottoMaker = new LottoMaker();

    private static final int PRICE_PER_LOTTO = 1000;

    public List<Lotto> issueLottoByPrice(int price) {
        return getLottosByCount(getCountByPrice(price));
    }

    private static int getCountByPrice(int price) {
        return price / PRICE_PER_LOTTO;
    }

    private static List<Lotto> getLottosByCount(int count) {
        ArrayList<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(lottoMaker.issueLotto());
        }
        return lottos;
    }
}
