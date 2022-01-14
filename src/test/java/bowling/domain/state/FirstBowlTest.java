package bowling.domain.state;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FirstBowlTest {

    private State firstBowl;

    @BeforeEach
    void setUp() {
        firstBowl = StateFactory.firstBowl(8);
    }

    @Test
    void create() {
        assertThat(firstBowl).isEqualTo(new FirstBowl(Pins.of(8)));
    }

    @Test
    @DisplayName("FirstBowl -> Miss")
    void miss() {
        assertThat(firstBowl.bowl(1)).isEqualTo(new Miss(Pins.of(8), Pins.of(1)));
    }

    @Test
    @DisplayName("FirstBowl -> Spare")
    void spare() {
        assertThat(firstBowl.bowl(2)).isEqualTo(new Spare(Pins.of(8), Pins.of(2)));
    }

}