package bowling.domain.frame;

import bowling.domain.Score;
import bowling.domain.state.State;

public interface Frame {

    Frame bowl(int downOfPins);

    int getNo();

    State getState();

    Score getScore();

    Score calculateExtraScore(Score beforeScore);

}
