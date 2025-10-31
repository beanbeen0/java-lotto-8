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

    private static String promptLottoNumbersInputMessage() {
        System.out.println("당첨 번호를 입력해주세요.");
        return Console.readLine();
    }

    public static WinningNumbers parseWinningNumbers(String input) {
        List<Integer> numbers = parseNumbers(input);
        return new WinningNumbers(numbers);
    }

    private static List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }
}
