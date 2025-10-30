package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FormatterTest {

    @Test
    @DisplayName("발권 정보 출력 : 1개 일 떄")
    void printIssuedLottos() {
        //given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        //when
        String result = Formatter.getIssuedMessage(lottos);

        //then
        Assertions.assertThat(result).isEqualTo("1개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("발권 정보 출력 : 2개 일 때")
    void printIssuedLottos2() {
        //given
        List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                new Lotto(List.of(1, 2, 3, 4, 5, 6))
        );

        //when
        String result = Formatter.getIssuedMessage(lottos);

        //then
        Assertions.assertThat(result).isEqualTo("2개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]\n[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("발권 정보 출력 : 오름차순")
    void printSorter() {
        //given
        List<Lotto> lottos = List.of(new Lotto(List.of(3, 2, 5, 1, 4, 6)));

        //when
        String result = Formatter.getIssuedMessage(lottos);

        //then
        Assertions.assertThat(result).isEqualTo("1개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]");
    }
}
