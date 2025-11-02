package lotto;

import java.util.Arrays;
import java.util.List;

public class InputHandler {

    public Price parseToPrice(String input) {
        return new Price(parseNumber(input));
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
            throw new IllegalArgumentException(Error.NOT_NUMBER_FORMAT.text());
        }
    }
}
