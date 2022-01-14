package bowling.domain.state;

import bowling.domain.exception.CannotCalculateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FinishedTest {

    @ParameterizedTest
    @MethodSource("providedStateForIsFinal")
    @DisplayName("Finished 상태에서 isFinal() -> true")
    void isFinal(State actual, boolean expected) {
        assertThat(actual.isFinal()).isEqualTo(expected);
    }

    private static Stream<Arguments> providedStateForIsFinal() {
        return Stream.of(
                Arguments.of(new Strike(), true),
                Arguments.of(new Spare(Pins.of(8), Pins.of(2)), true),
                Arguments.of(new Miss(Pins.of(8), Pins.of(1)), true),
                Arguments.of(StateFactory.ready(), false),
                Arguments.of(StateFactory.firstBowl(8), false)
        );
    }

    @ParameterizedTest
    @MethodSource("providedStateForBowl")
    @DisplayName("Finished 상태는 bowl() 메소드 호출시 -> CannotCalculateException 반환")
    void bowl(State actual) {
        assertThatThrownBy(() -> actual.bowl(8))
                .isInstanceOf(CannotCalculateException.class);
    }

    private static Stream<Arguments> providedStateForBowl() {
        return Stream.of(
                Arguments.of(new Strike()),
                Arguments.of(new Spare(Pins.of(8), Pins.of(2))),
                Arguments.of(new Miss(Pins.of(8), Pins.of(1)))
        );
    }


}