package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineCreator {

    public static Line createLine(int width) {
        List<Cross> crosses = new ArrayList<>();

        //첫번쨰 크로스
        Cross cross = Cross.first(RandomGenerator.generateRandom());
        crosses.add(cross);

        //중간 크로스
        while (cross.untilBeforeLastCross(width)) {
            cross = cross.next();
            crosses.add(cross);
        }

        //마지막 크로스
        cross = cross.last();
        crosses.add(cross);

        return new Line(crosses);
    }

}
