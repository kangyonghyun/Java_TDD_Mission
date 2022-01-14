package bowling.domain.state;

import java.util.Objects;

public class Strike extends Finished {

    private final Pins pins;

    public Strike(Pins firstPins) {
        this.pins = firstPins;
    }

    @Override
    public State bowl(int downOfPins) {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Strike strike = (Strike) o;
        return Objects.equals(pins, strike.pins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pins);
    }
}
