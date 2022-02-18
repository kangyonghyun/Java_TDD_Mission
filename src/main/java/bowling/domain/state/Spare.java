package bowling.domain.state;

import bowling.domain.Score;

import java.util.Objects;

public class Spare extends Finished {

    public static final String ERROR_NOT_SPARE_MSG = "스페어가 아닙니다!";

    private final Pins firstPins;
    private final Pins secondPins;

    public Spare(Pins firstPins, Pins secondPins) {
        if (!firstPins.isSpare(secondPins)) {
            throw new IllegalArgumentException(ERROR_NOT_SPARE_MSG);
        }
        this.firstPins = firstPins;
        this.secondPins = secondPins;
    }

    @Override
    public Score getScore() {
        return Score.spare();
    }

    @Override
    public Score calculateExtraScore(Score beforeScore) {
        beforeScore = this.firstPins.sumScore(beforeScore);
        if (beforeScore.canCalculateScore()) {
            return beforeScore;
        }
        return this.secondPins.sumScore(beforeScore);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Spare spare = (Spare) o;
        return Objects.equals(firstPins, spare.firstPins) && Objects.equals(secondPins, spare.secondPins);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstPins, secondPins);
    }

}
