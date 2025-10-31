package lotto;

import camp.nextstep.edu.missionutils.Console;

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
}
