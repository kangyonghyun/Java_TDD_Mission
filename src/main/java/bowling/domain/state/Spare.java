package bowling.domain.state;

import java.util.Objects;

public class Spare extends Finished {

    public static final String ERROR_NOT_SPARE_MSG = "스페어가 아닙니다!";
    private final Pins firstPins;
    private final Pins secondPins;

    public Spare(Pins firstPins, Pins secondPins) {
        if (!firstPins.isSpare(secondPins)) {
            throw new IllegalArgumentException(ERROR_NOT_SPARE_MSG);
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
        Spare spare = (Spare) o;
        return Objects.equals(firstPins, spare.firstPins) && Objects.equals(secondPins, spare.secondPins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPins, secondPins);
    }

}
