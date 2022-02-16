package bowling.domain.frame;

import bowling.domain.Board;
import bowling.domain.FrameResult;
import bowling.domain.Score;
import bowling.domain.exception.CannotCalculateException;
import bowling.domain.state.State;
import bowling.domain.state.StateFactory;

import java.util.Objects;

public class NormalFrame implements Frame {

    public static final int NOT_SCORE_VALUE = -1;
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
            this.next = createNext();
            return this.next;
        }
        return this;
    }

    private Frame createNext() {
        if (isLastFrame()) {
            return new LastFrame();
        }
        return new NormalFrame(no + 1);
    }

    private boolean isLastFrame() {
        return no + 1 == 10;
    }

    @Override
    public Score calculateScore() {
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
    public void addFrameResult(Board board) {
        board.add(getFrameResult());
        if (this.next != null) {
            this.next.addFrameResult(board);
        }
    }

    private FrameResult getFrameResult() {
        if (!this.state.isFinal()) {
            return new FrameResult(NOT_SCORE_VALUE);
        }
        try {
            return new FrameResult(calculateScore().getTotalScore());
        } catch (CannotCalculateException e) {
            return new FrameResult(NOT_SCORE_VALUE);
        }
    }

    @Override
    public Board createBoard() {
        Board board = new Board();
        addFrameResult(board);
        return board;
    }

    @Override
    public int getNo() {
        return this.no;
    }

    public State getState() {
        return this.state;
    }

    public Frame getNext() {
        return this.next;
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
