package ladder.domain;

import java.util.Objects;

public class Point {

    private final boolean left;
    private final boolean current;

    private Point(boolean left, boolean current) {
        if (left && current) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.current = current;
    }

    public static Point first(boolean current) {
        return new Point(false, current);
    }

    public Point next() {
        if (this.current) {
            return next(false);
        }
        return next(RandomGenerator.generateRandom());
    }

    public Point next(boolean current) {
        return new Point(this.current, current);
    }

    public Point last() {
        return new Point(this.current, false);
    }

    public Direction move() {
        if (this.current) {
            return Direction.RIGHT;
        }
        if (this.left) {
            return Direction.LEFT;
        }
        return Direction.SOUTH;
    }

    public boolean isCurrent() {
        return this.current;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return left == point.left && current == point.current;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, current);
    }

    @Override
    public String toString() {
        return "left=" + left +
                ", current=" + current;
    }

}
