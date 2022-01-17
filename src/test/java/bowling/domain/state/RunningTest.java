package bowling.domain.state;

import bowling.domain.exception.CannotCalculateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RunningTest {

    @ParameterizedTest
    @MethodSource("providedStateForRunning")
    @DisplayName("Running 상태는 isFinal -> false")
    void isFinal(State actual) {
        assertThat(actual.isFinal()).isFalse();
    }

    @ParameterizedTest
    @MethodSource("providedStateForRunning")
    @DisplayName("Running 상태는 getScore() -> CannotCalculateException 반환")
    void getScore(State actual) {
        assertThatThrownBy(actual::getScore)
                .isInstanceOf(CannotCalculateException.class);
    }

    private static Stream<Arguments> providedStateForRunning() {
        return Stream.of(
                Arguments.of(new FirstBowl(new Pins(8))),
                Arguments.of(new Ready())
        );
    }

}