package lotto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMakerTest {

    LottoMaker lottoMaker = new LottoMaker();

    @Test
    @DisplayName("로또 1개를 발행한다.")
    void issueLotto() {
        Lotto published = lottoMaker.issueLotto();
        assertThat(published).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("발행된 로또에는 6개의 숫자가 있다.")
    void checkNumberOfLotto() {
        Lotto published = lottoMaker.issueLotto();
        List<Integer> numbersInLotto = published.numbers();
        assertThat(numbersInLotto.size()).isEqualTo(6);
    }


    @Test
    @DisplayName("발행된 로또의 숫자들의 범위는 1~45이다.")
    void checkNumberRangeOfLotto() {
        Lotto published = lottoMaker.issueLotto();
        List<Integer> numbersInLotto = published.numbers();
        assertThat(numbersInLotto)
                .allMatch(number -> number >= 1 && number <= 45);
    }

    @Test
    @DisplayName("발행된 로또의 숫자들은 서로 중복되지 않는다.")
    void checkNotDuplicatedNumbersOfLotto() {
        Lotto published = lottoMaker.issueLotto();
        List<Integer> numbersInLotto = published.numbers();
        assertThat(numbersInLotto).doesNotHaveDuplicates();
    }
}