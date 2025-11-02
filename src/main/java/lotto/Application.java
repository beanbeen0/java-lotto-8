package lotto;

import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Price;
import lotto.domain.Standard;
import lotto.domain.WinningNumbers;
import lotto.messge.IssueMessage;
import lotto.messge.ReportMessage;
import lotto.service.LottoPurchaser;
import lotto.service.LottoStatisticsService;
import lotto.service.WinningHistory;

public class Application {

    private static final InputView inputView = new InputView();
    private static final LottoPurchaser lottoPurchaser = new LottoPurchaser();
    private static final LottoStatisticsService lottoStatisticsService = new LottoStatisticsService();

    public static void main(String[] args) {
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
