package ladder.domain;

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

}
