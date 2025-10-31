package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.PatternSyntaxException;

public class InputHandler {

    static int getInputPrice() {
        String input = promptInputPriceMessage();
        return parseToInputPrice(input);
    }

    private static String promptInputPriceMessage() {
        System.out.println("투입 금액을 입력해주세요.");
        return Console.readLine();
    }

    public static int parseToInputPrice(String input) {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("투입 금액은 숫자여야 합니다.", e);
        }
        validate(result);
        return result;
    }

    private static void validate(int result) {
        if (result < 0) throw new IllegalArgumentException("투입 금액은 0원 이상이어야 합니다.");
        if (result % 1000 != 0) throw new IllegalArgumentException("투입 금액은 1000원단위 이어야 합니다.");
    }

    private static String promptLottoNumbersInputMessage() {
        System.out.println("당첨 번호를 입력해주세요.");
        return Console.readLine();
    }

    public static List<Integer> parseToLottoNumbers(String input) {
        List<String> numbers = parseNumbers(input);
        return convertLottoNumbers(numbers);
    }

    private static List<String> parseNumbers(String input) {
        try {
            return Arrays.stream(input.split(",")).toList();
        } catch (PatternSyntaxException e) {
            throw new IllegalArgumentException("당첨 번호 형식이 올바르지 않습니다.", e);
        }
    }

    private static List<Integer> convertLottoNumbers(List<String> splited) {
        List<Integer> collectedLottoNumbers = splited.stream()
                .map(e -> convertLottoNumber(e))
                .toList();
        validateLottoNumbersCount(collectedLottoNumbers);
        validateNoDuplicated(collectedLottoNumbers);
        return collectedLottoNumbers;
    }

    private static void validateNoDuplicated(List<Integer> numbers) {
        Set<Integer> noDuplicated = new HashSet<>();
        for (int number : numbers) {
            if (!noDuplicated.add(number)) {
                throw new IllegalArgumentException("당첨 로또 숫자들은 중복되지 않아야 한다.");
            }
        }
    }

    private static int convertLottoNumber(String e) {
        int number = parseNumber(e);
        validateLottoNumberRange(number);
        return number;
    }

    private static void validateLottoNumbersCount(List<Integer> numbers) {
        if (numbers.size() != 6) throw new IllegalArgumentException("당첨 번호는 6개여야 합니다.");
    }

    private static int parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 숫자로 입력해주세요.", e);
        }
    }

    private static void validateLottoNumberRange(int tmp) {
        if (tmp < 1 || tmp > 45) {
            throw new IllegalArgumentException("숫자 범위는 1 ~ 45 이어야 합니다.");
        }
    }
}
