package bowling.domain;

import bowling.domain.state.Pins;

import java.util.Objects;

public class Score {

    public static final int MIN_LEFT = 0;
    public static final int ONE_LEFT = 1;
    public static final int TWO_LEFT = 2;

    private final int total;
    private final int left;

    public Score(int total, int left) {
        this.total = total;
        this.left = left;
    }

    public static Score miss(int total) {
        return new Score(total, MIN_LEFT);
    }

    public static Score spare() {
        return new Score(Pins.MAX_PINS, ONE_LEFT);
    }

    public static Score strike() {
        return new Score(Pins.MAX_PINS, TWO_LEFT);
    }

    public boolean canCalculateScore() {
        return this.left == MIN_LEFT;
    }

    public Score bowl(int downOfPins) {
        return new Score(this.total + downOfPins, this.left - 1);
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
