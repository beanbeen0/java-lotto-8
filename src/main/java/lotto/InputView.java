package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final InputHandler inputHandler = new InputHandler();

    private static final String PRICE_INPUT_MESSAGE = "투입 금액을 입력해주세요.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해주세요.";
    private static final String BONUS_NUMBERS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public Price readPrice() {
        System.out.println(PRICE_INPUT_MESSAGE);
        String input = Console.readLine();
        return inputHandler.parseToPrice(input);
    }

    public WinningNumbers readWinningNumbers() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
        String input = Console.readLine();
        return inputHandler.parseWinningNumbers(input);
    }

    public LottoNumber readBounusNumber() {
        System.out.println(BONUS_NUMBERS_INPUT_MESSAGE);
        String input = Console.readLine();
        return inputHandler.parseBonusNumber(input);
    }
}
