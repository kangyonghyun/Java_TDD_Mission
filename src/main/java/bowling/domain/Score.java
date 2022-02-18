package bowling.domain;

import bowling.domain.exception.CannotCalculateException;
import bowling.domain.state.Pins;

import java.util.Objects;

public class Score {

    private static final int ZERO_LEFT = 0;
    private static final int ONE_LEFT = 1;
    private static final int TWO_LEFT = 2;

    private final int total;
    private final int left;

    public Score(int total, int left) {
        this.total = total;
        if (left < 0) {
            throw new IllegalArgumentException("마이너스 left");
        }
        this.left = left;
    }

    public static Score miss(int total) {
        return new Score(total, ZERO_LEFT);
    }

    public static Score spare() {
        return new Score(Pins.MAX_PINS, ONE_LEFT);
    }

    public static Score strike() {
        return new Score(Pins.MAX_PINS, TWO_LEFT);
    }

    public Score bowl(int downOfPins) {
        return new Score(this.total + downOfPins, this.left - 1);
    }

    public boolean canCalculateScore() {
        return this.left == ZERO_LEFT;
    }

    public int getTotalScore() {
        if (!canCalculateScore()) {
            throw new CannotCalculateException();
        }
        return this.total;
    }

    public int getTotal() {
        return this.total;
    }

    public int getLeft() {
        return this.left;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Score score = (Score) o;
        return total == score.total && left == score.left;
    }

    @Override
    public int hashCode() {
        return Objects.hash(total, left);
    }

    @Override
    public String toString() {
        return "Score{" +
                "total=" + total +
                ", left=" + left +
                '}';
    }

}
