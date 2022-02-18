package bowling.domain;

import java.util.Objects;

public class FrameResult {

    private final int score;
    private int totalScore;

    public FrameResult(int score) {
        this.score = score;
    }

    public int addFrameScore(int beforeScore) {
        if (isUnScore()) {
            return this.totalScore = this.score;
        }
        return this.totalScore = this.score + beforeScore;
    }

    public boolean isUnScore() {
        return this.score == -1;
    }

    public int getTotalScore() {
        return this.totalScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FrameResult that = (FrameResult) o;
        return score == that.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(score);
    }

    @Override
    public String toString() {
        return "FrameResult{" +
                "score=" + score +
                ", totalScore=" + totalScore +
                '}';
    }

}
