package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderCreator {

    public LineCreator lineCreator;

    public LadderCreator(LineCreator lineCreator) {
        this.lineCreator = lineCreator;
    }

    public Ladder createLadder(int height, int width) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            Line line = this.lineCreator.createLine(width);
            lines.add(line);
        }

        return new Ladder(width, lines);
    }

}
