package bowling.domain.state;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeTest {

    @Test
    void create() {
        State strike = new Strike(10);
        assertThat(strike).isEqualTo(new Strike(10));
    }

}