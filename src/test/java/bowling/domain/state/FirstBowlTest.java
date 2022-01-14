package bowling.domain.state;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FirstBowlTest {

    @Test
    void create() {
        State firstBowl = new FirstBowl(new Pins(8));
        assertThat(firstBowl).isEqualTo(new FirstBowl(new Pins(8)));
    }

    @Test
    void miss() {
        State firstBowl = new FirstBowl(new Pins(8));
        State result = firstBowl.bowl(1);
        assertThat(result).isEqualTo(new Miss(new Pins(8), new Pins(1)));
    }

    @Test
    void spare() {
        State firstBowl = new FirstBowl(new Pins(8));
        State result = firstBowl.bowl(2);
        assertThat(result).isEqualTo(new Spare(new Pins(8), new Pins(2)));
    }

}