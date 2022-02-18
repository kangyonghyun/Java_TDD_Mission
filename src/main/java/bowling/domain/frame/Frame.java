package bowling.domain.frame;

import bowling.domain.Board;
import bowling.domain.Score;

public interface Frame {

    Frame bowl(int downOfPins);

    int getNo();

    Score calculateScore();

    Score calculateExtraScore(Score beforeScore);

    Board createBoard();

    void addFrameResult(Board board);

}
