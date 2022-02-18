package bowling.domain.state;

import bowling.domain.Score;

import java.util.Objects;

public class Pins {

    public static final int MAX_PINS = 10;
    public static final String ERROR_RANGE_OF_PINS_MSG = "볼링핀의 개수는 0~10 까지 입니다.";
    public static final int MIN_PINS = 0;

    private final int downOfPins;

    public Pins(int downOfPins) {
        checkDownOfPins(downOfPins);
        this.downOfPins = downOfPins;
    }

    public static Pins of(int downOfPins) {
        return new Pins(downOfPins);
    }

    public boolean isStrike() {
        return this.downOfPins == MAX_PINS;
    }

    public boolean isSpare(Pins secondPins) {
        return totalPins(secondPins) == MAX_PINS;
    }

    public int totalPins(Pins secondPins) {
        int total = this.downOfPins + secondPins.downOfPins;
        checkDownOfPins(total);
        return total;
    }

    private void checkDownOfPins(int downOfPins) {
        if (downOfPins > MAX_PINS || downOfPins < MIN_PINS) {
            throw new IllegalArgumentException(ERROR_RANGE_OF_PINS_MSG);
        }
    }

    public Score sumScore(Score beforeScore) {
        return beforeScore.bowl(this.downOfPins);
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
