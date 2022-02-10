package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.strategy.MovingStrategy;
import racingcar.domain.strategy.RandomMove;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    MovingStrategy strategy = new RandomMove();

    @Test
    void create() {
        Cars cars = new Cars(Arrays.asList(new Car("k3"), new Car("k5"), new Car("k7")));
        RacingGame racingGame = new RacingGame(cars, 3, strategy);
        assertThat(racingGame).isEqualTo(new RacingGame(cars, 3, strategy));
    }

    @Test
    void race() {
        Cars cars = new Cars(Arrays.asList(new Car("k3"), new Car("k5"), new Car("k7")));
        RacingGame racingGame = new RacingGame(cars, 3, () -> 4);
        RacingGame race = racingGame.race();
        assertThat(race.getTryNo()).isEqualTo(new TryNo(2));
        assertThat(race.getCars()).isEqualTo(new Cars(Arrays.asList(new Car("k3", 1), new Car("k5", 1), new Car("k7", 1))));
    }

}