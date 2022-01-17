package bowling.domain.state;

import bowling.domain.Score;

public interface State {

    State bowl(int downOfPins);

    boolean isFinal();

    Score getScore();

    Score calculateExtraScore(Score beforeScore);

}
