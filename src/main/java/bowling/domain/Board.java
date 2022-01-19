package bowling.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {

    private final List<FrameResult> results;
    private int gameScore;

    public Board() {
        this.results = new ArrayList<>();
    }

    public void add(FrameResult frameResult) {
        if (!frameResult.isUnScore()) {
            this.gameScore = frameResult.addTotalScore(gameScore);
        }
        this.results.add(frameResult);
    }

    public int getGameScore() {
        return this.gameScore;
    }

    public List<FrameResult> getResults() {
        return Collections.unmodifiableList(this.results);
    }

    @Override
    public String toString() {
        return "Board{" +
                "results=" + results +
                ", gameScore=" + gameScore +
                '}';
    }

}
