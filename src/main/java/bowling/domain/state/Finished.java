package bowling.domain.state;

import bowling.domain.exception.CannotCalculateException;

public abstract class Finished implements State {

    @Override
    public State bowl(int downOfPins) {
        throw new CannotCalculateException();
    }

    @Override
    public boolean isFinal() {
        return true;
    }

}
