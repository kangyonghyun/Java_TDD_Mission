package bowling.domain.state;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PinsTest {

    @Test
    void valid_create() {
        Pins pins = new Pins(8);
        assertThat(pins).isEqualTo(new Pins(8));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    void invalid_create(int downOfPins) {
        assertThatThrownBy(() -> new Pins(downOfPins))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isStrike() {
        Pins pins = new Pins(10);
        assertThat(pins.isStrike()).isTrue();
    }

    @Test
    void isSpare() {
        Pins first = new Pins(8);
        Pins second = new Pins(2);
        assertThat(first.isSpare(second)).isTrue();
    }

    @Test
    void of() {
        assertThat(Pins.of(10)).isEqualTo(new Pins(10));
    }

    @Test
    void invalid_of() {
        assertThatThrownBy(() -> Pins.of(11))
                .isInstanceOf(IllegalArgumentException.class);
    }

}