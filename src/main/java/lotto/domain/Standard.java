package lotto.domain;

import java.util.List;
import lotto.constant.Error;

public class Standard {
    private final WinningNumbers generalNumbers;
    private final LottoNumber bonusNumber;

    public Standard(WinningNumbers generalNumbers, LottoNumber bonusNumber) {
        this.generalNumbers = generalNumbers;
        this.bonusNumber = bonusNumber;
        validateNoContains(this.bonusNumber, this.generalNumbers);
    }

    public List<Integer> getGeneralNumbers() {
        return generalNumbers.values();
    }

    public int getBonusNumber() {
        return bonusNumber.value();
    }

    private static void validateNoContains(LottoNumber number, WinningNumbers winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(Error.DUPLICATED_BONUS_NUMBER.text());
        }
    }
}
