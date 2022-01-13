package bowling.domain.frame;

import bowling.domain.state.State;

public interface Frame {

    Frame bowl(int downOfPins);

    int getNo();

    State getState();

}
