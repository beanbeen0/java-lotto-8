package lotto;

import java.util.List;

public class Standard {
    private final List<Integer> generalNumbers;
    private final int bonusNumber;

    public Standard(List<Integer> generalNumbers, int bonusNumber) {
        this.generalNumbers = generalNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getGeneralNumbers() {
        return generalNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
