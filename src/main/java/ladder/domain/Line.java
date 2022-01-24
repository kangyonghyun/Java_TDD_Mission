package ladder.domain;

import java.util.List;

public class Line {

    private final List<Cross> crosses;

    public Line(List<Cross> crosses) {
        this.crosses = crosses;
    }

    public int move(int index) {
        return this.crosses.get(index).move();
    }

    public List<Cross> getCrosses() {
        return crosses;
    }

    @Override
    public String toString() {
        return "" + crosses;
    }

}
