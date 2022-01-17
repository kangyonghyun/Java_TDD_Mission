package bowling.domain.state;

import bowling.domain.Score;
import bowling.domain.exception.CannotCalculateException;

public class Ready extends Running {

    @Override
    public State bowl(int firstPins) {
        Pins downOfPins = new Pins(firstPins);
        if (downOfPins.isStrike()) {
            return new Strike();
        }
        return new FirstBowl(downOfPins);
    }

    @Override
    public Score calculateExtraScore(Score beforeScore) {
        throw new CannotCalculateException();
    }

}
