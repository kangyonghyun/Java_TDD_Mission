package lotto.domain;

import lotto.domain.generator.LottoAutoGenerator;
import lotto.domain.generator.LottoGenerator;
import lotto.domain.generator.LottoManualGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @Test
    void create_manual() {
        LottoGenerator generator = new LottoManualGenerator("1,2,3,4,5,6");
        LottoGame lottoGame = new LottoGame(generator);
        assertThat(lottoGame).isEqualTo(new LottoGame(generator));
    }

    @Test
    void create_auto() {
        LottoAutoGenerator generator = new LottoAutoGenerator(new Money(14000));
        LottoGame lottoGame = new LottoGame(generator);
        assertThat(lottoGame.getLotteries()).size().isEqualTo(14);
    }

    @ParameterizedTest
    @MethodSource("providedWinningLotto")
    void match(Lotto winning, LottoNumber bonusNo, Rank rank) {
        LottoGenerator generator = new LottoManualGenerator("1,2,3,4,5,6");
        LottoGame lottoGame = new LottoGame(generator);

        WiningLotto winingLotto = new WiningLotto(winning, bonusNo);

        LottoResult expected = new LottoResult();
        expected.putRank(rank);

        assertThat(lottoGame.match(winingLotto)).isEqualTo(expected);
    }

    private static Stream<Arguments> providedWinningLotto() {
        return Stream.of(
                Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.of(10), Rank.FIRST),
                Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 45)), LottoNumber.of(6), Rank.SECOND),
                Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 45)), LottoNumber.of(7), Rank.THIRD),
                Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 44,45)), LottoNumber.of(6), Rank.FOURTH),
                Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 43, 44,45)), LottoNumber.of(6), Rank.FIFTH),
                Arguments.of(Lotto.of(Arrays.asList(1, 2, 42, 43, 44,45)), LottoNumber.of(6), Rank.MISS),
                Arguments.of(Lotto.of(Arrays.asList(1, 41, 42, 43, 44,45)), LottoNumber.of(6), Rank.MISS),
                Arguments.of(Lotto.of(Arrays.asList(40, 41, 42, 43, 44,45)), LottoNumber.of(6), Rank.MISS)
        );
    }

}