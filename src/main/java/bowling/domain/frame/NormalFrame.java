package bowling.domain.frame;

import bowling.domain.Score;
import bowling.domain.state.State;
import bowling.domain.state.StateFactory;

import java.util.Objects;

public class NormalFrame implements Frame {

    private final int no;
    private State state;
    private Frame next;

    public NormalFrame(int no) {
        this(no, StateFactory.ready());
    }

    public NormalFrame(int no, State state) {
        this.no = no;
        this.state = state;
    }

    @Override
    public Frame bowl(int downOfPins) {
        this.state = this.state.bowl(downOfPins);
        if (this.state.isFinal()) {
            this.next = new NormalFrame(no + 1);
            return next;
        }
        return this;
    }

    @Override
    public int getNo() {
        return this.no;
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    public Score getScore() {
        Score score = this.state.getScore();
        if (score.canCalculateScore()) {
            return score;
        }
        return this.next.calculateExtraScore(score);
    }

    @Override
    public Score calculateExtraScore(Score beforeScore) {
        Score score = this.state.calculateExtraScore(beforeScore);
        if (score.canCalculateScore()) {
            return score;
        }
        return this.next.calculateExtraScore(score);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NormalFrame that = (NormalFrame) o;
        return no == that.no && Objects.equals(state, that.state) && Objects.equals(next, that.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, state, next);
    }

}
