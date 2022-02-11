package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    void create() {
        List<Car> cars = Arrays.asList(new Car("k3"), new Car("k5"));
        Winners winners = new Winners(cars);
        assertThat(winners).isEqualTo(new Winners(cars));
    }

    @Test
    void addWinner() {
        Winners winners = new Winners();
        winners.addWinner(new Car("k5", 5));
        assertThat(winners.getWinners()).containsExactly(new Car("k5", 5));
    }

}