package lotto;

import java.util.List;
import java.util.function.Supplier;
import lotto.messge.IssueMessage;
import lotto.messge.ReportMessage;
import lotto.service.LottoPurchaser;
import lotto.service.LottoStatisticsService;
import lotto.service.Standard;
import lotto.service.WinningHistory;

public class Controller {

    private final InputView inputView = new InputView();
    private final LottoPurchaser lottoPurchaser = new LottoPurchaser();
    private final LottoStatisticsService lottoStatisticsService = new LottoStatisticsService();

    public void run() {
        Price price = retryUntilValid(inputView::readPrice);
        List<Lotto> lottos = lottoPurchaser.issueLottoByPrice(price);
        System.out.println();
        System.out.println(IssueMessage.getMessage(lottos));

        WinningNumbers winningNumbers = retryUntilValid(inputView::readWinningNumbers);
        Standard standard = retryUntilValid(() -> {
            LottoNumber bonusNumber = inputView.readBounusNumber();
            return new Standard(winningNumbers, bonusNumber);
        });
        WinningHistory history = lottoStatisticsService.getStatistics(standard, lottos);
        double returnRate = history.calculateReturnRate(price.value());
        System.out.println();
        System.out.println(ReportMessage.getMessage(history, returnRate));
    }

    private static <T> T retryUntilValid(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
