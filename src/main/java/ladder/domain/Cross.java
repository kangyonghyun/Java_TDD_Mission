package ladder.domain;

public class Cross {

    private final Point point;
    private final int index;

    public Cross(int index, Point point) {
        this.index = index;
        this.point = point;
    }

    public int move() {
        if (point.move() == Direction.RIGHT) {
            return this.index + 1;
        }
        if (point.move() == Direction.LEFT) {
            return this.index - 1;
        }
        if (point.move() == Direction.SOUTH) {
            return this.index;
        }
        return this.index;
    }

    public int getIndex() {
        return this.index;
    }

    public Point getPoint() {
        return this.point;
    }

}
