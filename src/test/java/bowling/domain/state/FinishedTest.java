package bowling.domain.state;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FinishedTest {

    @ParameterizedTest
    @MethodSource("providedStateForIsFinal")
    void isFinal(State actual, boolean expected) {
        assertThat(actual.isFinal()).isEqualTo(expected);
    }

    private static Stream<Arguments> providedStateForIsFinal() {
        return Stream.of(
                Arguments.of(new Strike(Pins.of(10)), true),
                Arguments.of(new Spare(Pins.of(8), Pins.of(2)), true),
                Arguments.of(new Miss(Pins.of(8), Pins.of(1)), true),
                Arguments.of(StateFactory.ready(), false),
                Arguments.of(StateFactory.firstBowl(8), false)
        );
    }

}