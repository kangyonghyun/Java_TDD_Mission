package bowling.domain.state;

import java.util.Objects;

public class Pins {

    public static final int STRIKE_COUNT = 10;
    public static final int SPARE_COUNT = 10;

    private final int downOfPins;

    public Pins(int downOfPins) {
        if (downOfPins > 10 || downOfPins < 0) {
            throw new IllegalArgumentException("볼링핀의 개수는 0~10 까지 입니다.");
        }
        this.downOfPins = downOfPins;
    }

    public static Pins of(int downOfPins) {
        return new Pins(downOfPins);
    }

    public boolean isStrike() {
        return this.downOfPins == STRIKE_COUNT;
    }

    public boolean isSpare(Pins secondPins) {
        return totalPins(secondPins) == SPARE_COUNT;
    }

    private int totalPins(Pins secondPins) {
        return this.downOfPins + secondPins.downOfPins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pins pins = (Pins) o;
        return downOfPins == pins.downOfPins;
    }

    @Override
    public int hashCode() {
        return Objects.hash(downOfPins);
    }

}
