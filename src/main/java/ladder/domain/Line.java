package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Line {

    private final List<Cross> crosses;

    public Line(List<Cross> crosses) {
        this.crosses = crosses;
    }

    public int move(int index) {
        return this.crosses.get(index).move();
    }

    public List<Cross> getCrosses() {
        return this.crosses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line line = (Line) o;
        return Objects.equals(crosses, line.crosses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(crosses);
    }

    @Override
    public String toString() {
        return "Line= " + crosses;
    }

}
