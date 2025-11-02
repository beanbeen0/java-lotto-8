package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Standard;

public class LottoStatisticsService {

    private final LottoComparator lottoComparator = new LottoComparator();

    public WinningHistory getStatistics(Standard standard, List<Lotto> lottos) {
        return WinningHistory.create(lottoComparator.compare(standard, lottos));
    }
}
