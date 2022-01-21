package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Cross> crosses;

    public Line(List<Cross> crosses) {
        this.crosses = crosses;
    }

    public int move(int index) {
        return crosses.get(index).move();
    }

    public Line createLine(int width) {
        List<Cross> crosses = new ArrayList<>();
        // 첫번째 cross 채우고
        Cross first = new Cross(0, Point.first(true));
        crosses.add(first);

        for (int i = 1; i < width - 2; i++) {
            Cross cross = crosses.get(i - 1);
            crosses.add(new Cross(i, cross.getPoint().next(false)));
        }

//        crosses.add(new Cross());

        return new Line(crosses);
    }


}
