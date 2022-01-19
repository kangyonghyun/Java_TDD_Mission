package bowling.domain.frame;

import bowling.domain.Board;
import bowling.domain.Score;

public interface Frame {

    Frame bowl(int downOfPins);

    int getNo();

    Score getScore();

    Score calculateExtraScore(Score beforeScore);

    void addFrameResult(Board board);

    Board createBoard();

}
