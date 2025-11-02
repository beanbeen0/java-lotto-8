package lotto.domain;

import static lotto.constant.Constants.LOTTO_NUMBER_COUNT;

import java.util.HashSet;
import java.util.List;
import lotto.constant.Error;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .toList();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(Error.WRONG_COUNT_OF_LOTTO_NUMBERS.text());
        }
    }

    private void validateDuplication(List<Integer> values) {
        if (values.size() != new HashSet<>(values).size()) {
            throw new IllegalArgumentException(Error.DUPLICATED_LOTTO_NUMBERS.text());
        }
    }

    public List<Integer> numbers() {
        return numbers.stream()
                .map(LottoNumber::value)
                .toList();
    }

    public List<Integer> sortedNumbers() {
        return numbers.stream()
                .map(LottoNumber::value)
                .sorted()
                .toList();
    }
}
