package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineCreator {

    public static Line createLine(int width) {
        List<Cross> crosses = new ArrayList<>();

        //첫번쨰 크로스
        Cross first = new Cross(0, Point.first(true));
        crosses.add(first);

        //중간 크로스
        for (int i = 1; i < width - 2; i++) {
            Cross cross = crosses.get(i - 1);
            crosses.add(new Cross(i, cross.getPoint().next(false)));
        }

        //마지막 크로스
        crosses.add(new Cross(width, crosses.get(width - 2).getPoint().last()));

        return new Line(crosses);
    }

}
