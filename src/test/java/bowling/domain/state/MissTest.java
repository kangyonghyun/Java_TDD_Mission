package bowling.domain.state;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MissTest {

    @Test
    void create() {
        Miss miss = new Miss(new Pins(8), new Pins(1));
        assertThat(miss).isEqualTo(new Miss(new Pins(8), new Pins(1)));
    }

}