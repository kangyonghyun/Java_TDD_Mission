package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void create() {
        Car car = new Car("k5", 1);
        assertThat(car).isEqualTo(new Car("k5", 1));
    }

    @Test
    void move() {
        Car car = new Car("k5");
        assertThat(car.move(4)).isEqualTo(new Car("k5", 1));
    }

    @Test
    @DisplayName("맥스 값이 바뀔때")
    void maxPosition() {
        Car car = new Car("k5", 2);
        Position max = car.maxPosition(new Position(3));
        assertThat(max).isEqualTo(new Position(3));
    }

    @Test
    @DisplayName("맥스 값이 안바뀔때")
    void maxPosition_x() {
        Car car = new Car("k5", 4);
        Position max = car.maxPosition(new Position(3));
        assertThat(max).isEqualTo(new Position(4));
    }

    @Test
    void isWinner() {
        Car car = new Car("k5", 4);
        assertThat(car.isWinner(new Position(4))).isTrue();
        assertThat(car.isWinner(new Position(3))).isFalse();
    }

}