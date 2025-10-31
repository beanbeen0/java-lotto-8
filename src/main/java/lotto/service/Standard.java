package lotto.service;

import java.util.List;
import lotto.LottoNumber;
import lotto.WinningNumbers;

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
            throw new IllegalArgumentException("보너스 번호는 당첨 번호들과 중복되지 않아야 합니다.");
        }
    }
}
