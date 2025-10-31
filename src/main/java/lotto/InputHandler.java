package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputHandler {

    static Price getInputPrice() {
        String input = promptInputPriceMessage();
        return parseToPrice(input);
    }

    private static String promptInputPriceMessage() {
        System.out.println("투입 금액을 입력해주세요.");
        return Console.readLine();
    }

    public static Price parseToPrice(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("투입 금액은 숫자여야 합니다.", e);
        }
        return new Price(result);
    }

    private static String promptWinningNumbersInputMessage() {
        System.out.println("당첨 번호를 입력해주세요.");
        return Console.readLine();
    }

    public static WinningNumbers parseWinningNumbers(String input) {
        List<Integer> numbers = parseNumbers(input);
        return new WinningNumbers(numbers);
    }

    private static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(token -> parseNumber(token))
                .toList();
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 입력 해야 합니다.");
        }
    }

    private static String promptWinningBonusNumberInputMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static LottoNumber parseBonusNumber(String input) {
        int number = parseNumber(input);
        return new LottoNumber(number);
    }
}
