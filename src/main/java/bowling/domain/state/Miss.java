package bowling.domain.state;

import java.util.Objects;

public class Miss extends Finished {

    private final Pins firstPins;
    private final Pins secondPins;

    public Miss(Pins firstPins, Pins secondPins) {
        if (firstPins.totalPins(secondPins) > Pins.MAX_PINS) {
            throw new IllegalArgumentException(Pins.ERROR_RANGE_OF_PINS_MSG);
        }
        this.firstPins = firstPins;
        this.secondPins = secondPins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Miss miss = (Miss) o;
        return Objects.equals(firstPins, miss.firstPins) && Objects.equals(secondPins, miss.secondPins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPins, secondPins);
    }

}
