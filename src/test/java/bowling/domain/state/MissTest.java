package bowling.domain.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MissTest {

    private State miss;

    @BeforeEach
    void setUp() {
        miss = StateFactory.firstBowl(8).bowl(1);
    }

    @Test
    void create() {
        assertThat(miss).isEqualTo(new Miss(Pins.of(8), Pins.of(1)));
    }

    @Test
    void invalid_create() {
        assertThatThrownBy(() -> new Miss(Pins.of(8), Pins.of(3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}