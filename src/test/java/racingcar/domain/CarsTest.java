package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    void create() {
        Cars cars = new Cars(Arrays.asList(new Car("k5"), new Car("k3")));
        assertThat(cars.getCars()).size().isEqualTo(2);
    }

    @Test
    void moveCars() {
        Cars cars = new Cars(Arrays.asList(new Car("k5"), new Car("k3")));
        Cars newCars = cars.moveCars(() -> 4);
        assertThat(newCars.getCars()).size().isEqualTo(2);
        assertThat(newCars.getCars()).containsExactly(new Car("k5", 1), new Car("k3", 1));
    }

    @Test
    @DisplayName("중복 1등 찾기")
    void double_findWinners() {
        Cars cars = new Cars(Arrays.asList(
                new Car("k5", 1),
                new Car("k3", 2),
                new Car("sm5", 2)));
        assertThat(cars.findWinners().getWinners())
                .containsExactly(new Car("k3", 2), new Car("sm5", 2));
    }

    @Test
    @DisplayName("단독 1등 찾기")
    void single_findWinners() {
        Cars cars = new Cars(Arrays.asList(
                new Car("k5", 1),
                new Car("k3", 2),
                new Car("sm5", 3)));
        assertThat(cars.findWinners().getWinners())
                .containsExactly(new Car("sm5", 3));
    }



}