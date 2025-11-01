package lotto;

import java.util.Arrays;
import java.util.List;

public class InputHandler {

    public Price parseToPrice(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("투입 금액은 숫자여야 합니다.", e);
        }
        return new Price(result);
    }

    public WinningNumbers parseWinningNumbers(String input) {
        List<Integer> numbers = parseNumbers(input);
        return new WinningNumbers(numbers);
    }

    public LottoNumber parseBonusNumber(String input) {
        return new LottoNumber(parseNumber(input));
    }

    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(token -> parseNumber(token))
                .toList();
    }

    private int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 입력 해야 합니다.");
        }
    }
}
