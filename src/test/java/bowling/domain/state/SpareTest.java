package bowling.domain.state;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SpareTest {

    @Test
    void create() {
        State spare = new Spare(new Pins(8), new Pins(2));
        assertThat(spare).isEqualTo(new Spare(new Pins(8), new Pins(2)));
    }

}