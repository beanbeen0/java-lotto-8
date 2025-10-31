package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import lotto.messge.LottoNumber;

public class WinningNumbers {

    private static final int LOTTO_NUMBER_COUNT = 6;

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
            throw new IllegalArgumentException(
                    String.format("당첨 번호는 %d개여야 합니다.", LOTTO_NUMBER_COUNT)
            );
        }
    }

    private void validateDuplication(List<Integer> values) {
        if (values.size() != new HashSet<>(values).size()) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> values() {
        return values.stream()
                .map(LottoNumber::value)
                .toList();
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
