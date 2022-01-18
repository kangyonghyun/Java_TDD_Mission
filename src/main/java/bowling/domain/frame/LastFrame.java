package bowling.domain.frame;

import bowling.domain.Score;
import bowling.domain.exception.CannotCalculateException;
import bowling.domain.exception.GameOverException;
import bowling.domain.state.State;
import bowling.domain.state.StateFactory;

import java.util.LinkedList;
import java.util.Objects;

public class LastFrame implements Frame {

    public static final int MAX_FRAME = 10;
    private final LinkedList<State> states = new LinkedList<>();

    public LastFrame() {
        states.add(StateFactory.ready());
    }

    @Override
    public Frame bowl(int downOfPins) {
        if (isEndGame()) {
            throw new GameOverException();
        }

        State currentState = this.states.getLast();

        if (currentState.isFinal()) {
            this.states.add(StateFactory.firstBowl(downOfPins));
            return this;
        }

        this.states.removeLast();
        this.states.add(currentState.bowl(downOfPins));

        return this;
    }

    private boolean isEndGame() {
        try {
            return isFinished();
        } catch (CannotCalculateException e) {
            return false;
        }
    }

    private boolean isFinished() {
        Score score = getScore();
        return score.canCalculateScore();
    }

    @Override
    public int getNo() {
        return MAX_FRAME;
    }

    @Override
    public Score getScore() {
        Score score = getFirstScore();
        for (int i = 1; i < this.states.size(); i++) {
            State state = this.states.get(i);
            score = state.calculateExtraScore(score);
        }
        return score;
    }

    private Score getFirstScore() {
        return this.states.getFirst().getScore();
    }

    @Override
    public Score calculateExtraScore(Score beforeScore) {
        for (State state : states) {
            beforeScore = state.calculateExtraScore(beforeScore);
        }
        return beforeScore;
    }

    public LinkedList<State> getStates() {
        return this.states;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LastFrame lastFrame = (LastFrame) o;
        return Objects.equals(states, lastFrame.states);
    }

    @Override
    public int hashCode() {
        return Objects.hash(states);
    }
}
