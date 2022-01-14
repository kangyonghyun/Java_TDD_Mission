package bowling.domain.state;

import java.util.Objects;

public class FirstBowl extends Running {

    private final Pins firstPins;

    public FirstBowl(Pins downOfPins) {
        this.firstPins = downOfPins;
    }

    @Override
    public State bowl(int downOfPins) {
        Pins secondPins = new Pins(downOfPins);
        if (this.firstPins.isSpare(secondPins)) {
            return new Spare(this.firstPins, secondPins);
        }
        return new Miss(this.firstPins, secondPins);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FirstBowl firstBowl = (FirstBowl) o;
        return Objects.equals(firstPins, firstBowl.firstPins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPins);
    }

}
