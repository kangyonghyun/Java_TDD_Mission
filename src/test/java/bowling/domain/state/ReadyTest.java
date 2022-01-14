package bowling.domain.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
        State ready = new Ready();
        assertThat(ready.bowl(10)).isExactlyInstanceOf(Strike.class);
    }

}