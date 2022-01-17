package bowling.domain.state;

import bowling.domain.Score;
import bowling.domain.exception.CannotCalculateException;

public abstract class Running implements State {

    @Override
    public boolean isFinal() {
        return false;
    }

    @Override
    public Score getScore() {
        throw new CannotCalculateException("계산할 수 없습니다.");
    }

}
