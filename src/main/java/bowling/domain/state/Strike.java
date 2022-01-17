package bowling.domain.state;

import bowling.domain.Score;

public class Strike extends Finished {

    @Override
    public Score getScore() {
        return Score.strike();
    }

    @Override
    public Score calculateExtraScore(Score beforeScore) {
        if (beforeScore.canCalculateScore()) {
            return beforeScore;
        }
        return beforeScore.bowl(Pins.MAX_PINS);
    }

}
