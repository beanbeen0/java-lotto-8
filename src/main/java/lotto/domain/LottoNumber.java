package lotto.domain;

import static lotto.constant.Constants.LOTTO_MAX_NUMBER;
import static lotto.constant.Constants.LOTTO_MIN_NUMBER;

import java.util.Objects;
import lotto.constant.Error;

public class LottoNumber {
    
    private final int value;

    public LottoNumber(int value) {
        validateRange(value);
        this.value = value;
    }

    private void validateRange(int value) {
        if (value < LOTTO_MIN_NUMBER || value > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(Error.WRONG_RANGE_OF_LOTTO_NUMBER.text());
        }
    }

    public int value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
