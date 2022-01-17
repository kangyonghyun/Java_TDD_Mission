package bowling.domain.state;

import bowling.domain.Score;
import bowling.domain.exception.CannotCalculateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ReadyTest {

    private State ready;

    @BeforeEach
    void setUp() {
        ready = StateFactory.ready();
    }

    @Test
    @DisplayName("Ready 상태 -> FirstBowl 상태")
    void bowl_firstBowl() {
        assertThat(ready.bowl(5)).isEqualTo(StateFactory.firstBowl(5));
    }

    @Test
    @DisplayName("Ready 상태 -> Strike 상태")
    void bowl_strike() {
        assertThat(ready.bowl(10)).isExactlyInstanceOf(Strike.class);
    }

    @Test
    @DisplayName("Ready 상태에선 calculateExtraScore 호출 -> CannotCalculateException 반환")
    void calculateExtraScore() {
        assertThatThrownBy(() -> ready.calculateExtraScore(Score.spare()))
                .isInstanceOf(CannotCalculateException.class);
    }

}