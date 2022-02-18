package bowling.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Board {

    private final List<FrameResult> results;
    private int gameScore;

    public Board() {
        this.results = new ArrayList<>();
    }

    public void add(FrameResult frameResult) {
        if (!frameResult.isUnScore()) {
            this.gameScore = frameResult.addFrameScore(gameScore);
        }
        this.results.add(frameResult);
    }

    public List<FrameResult> getResults() {
        return Collections.unmodifiableList(this.results);
    }

    public int getGameScore() {
        return this.gameScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Board board = (Board) o;
        return gameScore == board.gameScore && Objects.equals(results, board.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results, gameScore);
    }

    @Override
    public String toString() {
        return "Board{" +
                "results=" + results +
                ", gameScore=" + gameScore +
                '}';
    }

}
