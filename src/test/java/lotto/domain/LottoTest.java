package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void create() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @ParameterizedTest
    @MethodSource("providedNumbers")
    @DisplayName("숫자 6자리인지 검증")
    void numbers_6_x(List<Integer> actual) {
        assertThatThrownBy(() -> Lotto.of(actual))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> providedNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5))
        );
    }

    @ParameterizedTest
    @MethodSource("providedLotto")
    void match(Lotto other, int expected) {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.match(other)).isEqualTo(expected);
    }

    private static Stream<Arguments> providedLotto() {
        return Stream.of(
                Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)), 6),
                Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 45)), 5),
                Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 4, 44, 45)), 4),
                Arguments.of(Lotto.of(Arrays.asList(1, 2, 3, 43, 44, 45)), 3),
                Arguments.of(Lotto.of(Arrays.asList(1, 2, 42, 43, 44, 45)), 2),
                Arguments.of(Lotto.of(Arrays.asList(1, 41, 42, 43, 44, 45)), 1),
                Arguments.of(Lotto.of(Arrays.asList(40, 41, 42, 43, 44, 45)), 0)
        );
    }

    @Test
    void containBonusNo() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        boolean contain = lotto.containBonusNo(LottoNumber.of(6));
        boolean notContain = lotto.containBonusNo(LottoNumber.of(7));
        assertThat(contain).isTrue();
        assertThat(notContain).isFalse();
    }

}