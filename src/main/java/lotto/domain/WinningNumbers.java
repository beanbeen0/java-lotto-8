package lotto.domain;

import static lotto.constant.Constants.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import lotto.constant.Error;

public class WinningNumbers {

    private final List<LottoNumber> values;

    public WinningNumbers(List<Integer> values) {
        validate(values);
        this.values = values.stream()
                .map(LottoNumber::new)
                .toList();
    }

    private void validate(List<Integer> values) {
        validateSize(values);
        validateDuplication(values);
    }

    private void validateSize(List<Integer> values) {
        if (values.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(Error.WRONG_COUNT_OF_WINNING_NUMBERS.text());
        }
    }

    private void validateDuplication(List<Integer> values) {
        if (values.size() != new HashSet<>(values).size()) {
            throw new IllegalArgumentException(Error.DUPLICATED_WINNING_NUMBER.text());
        }
    }

    public List<Integer> values() {
        return values.stream()
                .map(LottoNumber::value)
                .toList();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return values.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }
}
