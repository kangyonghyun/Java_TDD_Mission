package bowling.domain;

import java.util.Objects;

public class Score {

    public static final int MIN_LEFT = 0;
    private final int total;
    private final int left;

    public Score(int total, int left) {
        this.total = total;
        this.left = left;
    }

    public static Score miss(int total) {
        return new Score(total, 0);
    }

    public static Score strike() {
        return new Score(10, 2);
    }

    public static Score spare() {
        return new Score(10, 1);
    }

    public boolean canCalculateScore() {
        return this.left == MIN_LEFT;
    }

    public Score bowl(int downOfPins) {
        return new Score(this.total + downOfPins, this.left - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
