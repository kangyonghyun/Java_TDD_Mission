package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    private Cars cars;
    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        cars = new Cars(Arrays.asList(new Car("k3"), new Car("k5"), new Car("k7")));
        racingGame = new RacingGame(cars, 3);
    }

    @Test
    void create() {
        assertThat(racingGame).isEqualTo(new RacingGame(cars, 3));
    }

    @Test
    void race() {
        RacingGame firstRound = racingGame.race(() -> 4);
        Cars firstResult = new Cars(Arrays.asList(new Car("k3", 1), new Car("k5", 1), new Car("k7", 1)));

        assertThat(firstRound.getTryNo()).isEqualTo(new TryNo(2));
        assertThat(firstRound.getCars()).isEqualTo(firstResult);

        RacingGame secondRound = firstRound.race(() -> 3);
        Cars secondResult = new Cars(Arrays.asList(new Car("k3", 1), new Car("k5", 1), new Car("k7", 1)));

        assertThat(secondRound.getTryNo()).isEqualTo(new TryNo(1));
        assertThat(secondRound.getCars()).isEqualTo(secondResult);

        RacingGame thirdRound = secondRound.race(() -> 4);
        Cars thirdResult = new Cars(Arrays.asList(new Car("k3", 2), new Car("k5", 2), new Car("k7", 2)));
        Winners winners = new Winners(Arrays.asList(new Car("k3", 2), new Car("k5", 2), new Car("k7", 2)));

        assertThat(thirdRound.getTryNo()).isEqualTo(new TryNo(0));
        assertThat(thirdRound.getCars()).isEqualTo(thirdResult);
        assertThat(thirdRound.isEndGame()).isTrue();
        assertThat(thirdRound.findWinners()).isEqualTo(winners);
    }

}