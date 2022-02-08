package lotto.domain;

import lotto.domain.generator.LottoAutoGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @Test
    void autoGenerate() {
        LottoAutoGenerator lottoAutoGenerator = new LottoAutoGenerator();
        List<Lotto> lotteries = lottoAutoGenerator.generate(new Money(14000));
        assertThat(lotteries).size().isEqualTo(14);
    }

    @Test
    void match() {
        List<Lotto> lotteries = new ArrayList<>();
        lotteries.add(Lotto.of(Arrays.asList(1,2,3,4,5,6)));

        LottoGame lottoGame = new LottoGame(lotteries);
        WiningLotto winingLotto = new WiningLotto(Lotto.of(Arrays.asList(1,2,3,4,5,6)), LottoNumber.of(10));

        LottoResult result = lottoGame.match(winingLotto);
        assertThat(result.getResults().get(Rank.FIRST)).isEqualTo(1);
    }

}