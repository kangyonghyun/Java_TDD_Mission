package bowling.domain.state;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeTest {

    @Test
    void create() {
        State strike = new Strike(new Pins(10));
        assertThat(strike).isEqualTo(new Strike(new Pins(10)));
    }

}