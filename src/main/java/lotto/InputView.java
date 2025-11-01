package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputHandler inputHandler = new InputHandler();

    public Price readPrice() {
        System.out.println("투입 금액을 입력해주세요.");
        String input = Console.readLine();
        return inputHandler.parseToPrice(input);
    }

    public WinningNumbers readWinningNumbers() {
        System.out.println("당첨 번호를 입력해주세요.");
        String input = Console.readLine();
        return inputHandler.parseWinningNumbers(input);
    }

    public LottoNumber readBounusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        return inputHandler.parseBonusNumber(input);
    }
}
