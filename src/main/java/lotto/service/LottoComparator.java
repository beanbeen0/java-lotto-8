package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Standard;

public class LottoComparator {

    public List<LottoRank> compare(Standard standard, List<Lotto> lottos) {
        List<LottoRank> results = new ArrayList<>();
        for (Lotto lotto : lottos) {
            results.add(compare(standard, lotto));
        }
        return results;
    }

    public LottoRank compare(Standard standard, Lotto lotto) {
        int matchedCount = getMatchedCount(standard.getGeneralNumbers(), lotto);
        boolean hasBonus = checkBonus(standard.getBonusNumber(), lotto);
        return LottoRank.getRank(matchedCount, hasBonus);
    }

    private static int getMatchedCount(List<Integer> standardNumbers, Lotto lotto) {
        int count = 0;
        for (int num : standardNumbers) {
            for (int lottoNum : lotto.numbers()) {
                if (num == lottoNum) count++;
            }
        }
        return count;
    }

    private static boolean checkBonus(int bonusNumber, Lotto lotto) {
        for (int num : lotto.numbers()) {
            if (num == bonusNumber) {
                return true;
            }
        }
        return false;
    }
}
