package racingcar.domain;

import racingcar.domain.strategy.MovingStrategy;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars of(List<String> names) {
        List<Car> cars = names.stream()
                .map(Car::of)
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    public Cars moveCars(MovingStrategy strategy) {
        List<Car> newCars = this.cars.stream()
                .map(car -> car.move(strategy.generate()))
                .collect(Collectors.toList());
        return new Cars(newCars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public Winners findWinners() {
        return winners(getMaxPosition());
    }

    private Winners winners(Position maxPosition) {
        Winners winners = new Winners();
        this.cars.stream()
                .filter(car -> car.isWinner(maxPosition))
                .forEach(winners::addWinner);
        return winners;
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : this.cars) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

}
