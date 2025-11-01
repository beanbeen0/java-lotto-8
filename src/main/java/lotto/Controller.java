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
        // 투입 금액
        Price price = retryUntilValid(inputView::readPrice);

        // 로또 구매 및 출력
        List<Lotto> lottos = lottoPurchaser.issueLottoByPrice(price);;
        System.out.println(IssueMessage.getMessage(lottos));

        // 당첨 번호 및 보너스 번호 입력 받기
        WinningNumbers winningNumbers = retryUntilValid(inputView::readWinningNumbers);
        Standard standard = retryUntilValid(() -> {
            LottoNumber bonusNumber = inputView.readBounusNumber();
            return new Standard(winningNumbers, bonusNumber);
        });

        // 로또 판정 및 출력
        WinningHistory history = lottoStatisticsService.getStatistics(standard, lottos);
        double returnRate = history.calculateReturnRate(price.value());
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
