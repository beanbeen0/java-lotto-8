package lotto;

import static lotto.Constants.*;

public enum Error {

    NEGATIVE_PRICE("투입 금액은 0원 이상이어야 합니다."),
    WRONG_UNIT_OF_PRICE("투입 금액은 " + LOTTO_UNIT_PRICE + "원 단위이어야 합니다."),

    DUPLICATED_BONUS_NUMBER("보너스 번호는 당첨 번호들과 중복되지 않아야 합니다."),
    NOT_NUMBER_FORMAT("숫자여야 합니다."),

    DUPLICATED_LOTTO_NUMBERS("로또 번호는 중복될 수 없습니다."),
    WRONG_COUNT_OF_LOTTO_NUMBERS("로또 번호는 " + LOTTO_NUMBER_COUNT + "개여야 합니다."),
    WRONG_RANGE_OF_LOTTO_NUMBER(
            "로또 숫자는 "+ LOTTO_MIN_NUMBER + " ~ "+ LOTTO_MAX_NUMBER +" 사이의 숫자합니다."),

    WRONG_COUNT_OF_WINNING_NUMBERS("당첨 번호는 " + LOTTO_NUMBER_COUNT + "개여야 합니다."),
    DUPLICATED_WINNING_NUMBER("당첨 번호는 중복될 수 없습니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String text() {
        return message;
    }
}
