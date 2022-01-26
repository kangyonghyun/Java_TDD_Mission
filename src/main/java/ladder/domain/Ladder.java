package ladder.domain;

import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final int width;

    public Ladder(int width, List<Line> lines) {
        this.width = width;
        this.lines = lines;
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public int getWidth() {
        return this.width;
    }

    public LadderResult play() {
        LadderResult result = new LadderResult();
        for (int i = 0; i < width; i++) {
            result.put(i, getResult(i));
        }
        return result;
    }

    private int getResult(int index) {
        int position = index;
        for (Line line : this.lines) {
            position = line.move(position);
        }
        return position;
    }

}
