package bowling.domain.state;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SpareTest {

    @Test
    void create() {
        State spare = new Spare(Pins.of(8), Pins.of(2));
        assertThat(spare).isEqualTo(new Spare(Pins.of(8), Pins.of(2)));
    }

    @Test
    void invalid_create() {
        assertThatThrownBy(() -> new Spare(Pins.of(8), Pins.of(3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

}