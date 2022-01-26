package ladder.domain;

public class Cross {

    private final int index;
    private final Point point;

    public Cross(int index, Point point) {
        this.index = index;
        this.point = point;
    }

    public static Cross first(boolean right){
        return new Cross(0, Point.first(right));
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

    public Cross next() {
        return new Cross(this.index + 1, this.point.next());
    }

    public Cross next(boolean right) {
        return new Cross(this.index + 1, this.point.next(right));
    }

    public Cross last() {
        return new Cross(this.index + 1, this.point.last());
    }

    public boolean untilBeforeLastCross(int width) {
        return this.index < width - 2;
    }

    public boolean isRight() {
        return this.point.isCurrent();
    }

    public int getIndex() {
        return this.index;
    }

    public Point getPoint() {
        return this.point;
    }

    @Override
    public String toString() {
        return point + ", index=" + index;
    }

}
