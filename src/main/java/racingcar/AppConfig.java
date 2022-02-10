package racingcar;

import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.RandomMove;

public class AppConfig {

    public MovingStrategy strategy() {
        return new RandomMove();
    }

}
