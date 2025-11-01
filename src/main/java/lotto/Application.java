package lotto;

import java.util.List;
import java.util.function.Supplier;
import lotto.messge.IssueMessage;
import lotto.messge.ReportMessage;
import lotto.service.LottoComparator;
import lotto.service.LottoPurchaseService;
import lotto.service.Standard;
import lotto.service.WinningHistory;

public class Application {
    public static void main(String[] args) {
        // 투입 금액
        Price price = retryUntilValid(InputHandler::getInputPrice);

        // 로또 구매 및 출력
        LottoPurchaseService lottoPurchaseService = new LottoPurchaseService();
        List<Lotto> issuedLottos = lottoPurchaseService.issueLottoByPrice(price);
        System.out.println(IssueMessage.getMessage(issuedLottos));

        // 당첨 번호 및 보너스 번호 입력 받기
        WinningNumbers winningNumbers = retryUntilValid(InputHandler::getWinningNumbers);
        Standard standard = retryUntilValid(() -> {
            LottoNumber bonusNumber = InputHandler.getBonusNumber();
            return new Standard(winningNumbers, bonusNumber);
        });

        // 로또 판정 및 출력
        LottoComparator lottoComparator = new LottoComparator();
        WinningHistory history = WinningHistory.create(lottoComparator.compare(standard, issuedLottos));
        System.out.println(ReportMessage.getMessage(history, history.calculateReturnRate(price.value())));
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
