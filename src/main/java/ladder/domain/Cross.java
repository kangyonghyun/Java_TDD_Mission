package ladder.domain;

import java.util.Objects;

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
        return this.index;
    }

    public Cross next() {
        return new Cross(this.index + 1, this.point.next());
    }

    // 테스트용
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cross cross = (Cross) o;
        return index == cross.index && Objects.equals(point, cross.point);
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, point);
    }

    @Override
    public String toString() {
        return "Cross{" +
                "index=" + index +
                ", point=" + point +
                '}';
    }

}
