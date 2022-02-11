package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2, 7})
    void not_rank() {
        assertThatThrownBy(() -> Rank.valueOf(7, false))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void prize() {
        assertThat(Rank.FIFTH.prize(2)).isEqualTo(new Money(2 * 5_000));
    }

}