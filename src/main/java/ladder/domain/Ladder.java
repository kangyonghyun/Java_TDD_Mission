package ladder.domain;

import ladder.domain.result.LadderResult;

import java.util.List;
import java.util.Objects;

public class Ladder {

    private final int width;
    private final List<Line> lines;

    public Ladder(int width, List<Line> lines) {
        this.width = width;
        this.lines = lines;
    }

    public LadderResult play() {
        LadderResult result = new LadderResult();
        for (int i = 0; i < this.width; i++) {
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

    public List<Line> getLines() {
        return this.lines;
    }

    public int getWidth() {
        return this.width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ladder ladder = (Ladder) o;
        return width == ladder.width && Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, lines);
    }

}
