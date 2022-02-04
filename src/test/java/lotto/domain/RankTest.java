package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @MethodSource("providedMatchCountAndBonus")
    void rank(int match, boolean matchBonus, Rank expected) {
        assertThat(Rank.valueOf(match, matchBonus)).isEqualTo(expected);
    }

    private static Stream<Arguments> providedMatchCountAndBonus() {
        return Stream.of(
                Arguments.of(1, false, Rank.MISS),
                Arguments.of(2, false, Rank.MISS),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(6, false, Rank.FIRST)
        );
    }

}