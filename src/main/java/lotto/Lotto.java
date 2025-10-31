package lotto;

import java.util.HashSet;
import java.util.List;

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
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplication(List<Integer> values) {
        if (values.size() != new HashSet<>(values).size()) {
            throw new IllegalArgumentException("당첨 번호는 중복될 수 없습니다.");
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
