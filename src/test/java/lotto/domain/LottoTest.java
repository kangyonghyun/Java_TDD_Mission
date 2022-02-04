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
    @DisplayName("숫자 6자리 포함하는지 검증")
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

    @Test
    void match() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        int countOfMatch = lotto.match(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(countOfMatch).isEqualTo(6);
    }

    @Test
    void containBonusNo() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        boolean result = lotto.containBonusNo(LottoNumber.of(6));
        assertThat(result).isTrue();
    }

}