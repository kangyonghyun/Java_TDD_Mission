package racingcar.domain;

import racingcar.domain.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public Cars moveCars(MovingStrategy strategy) {
        List<Car> newCars = new ArrayList<>();
        for (Car car : this.cars) {
            Car newCar = car.move(strategy.generate());
            newCars.add(newCar);
        }
        return new Cars(newCars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(this.cars);
    }

    public List<Car> findWinners1() {
        List<Car> winners = new ArrayList<>();
        Position maxPosition = getMaxPosition();
        for (Car car : this.cars) {
            if (car.isWinner(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    public Winners findWinners() {
        return winners(getMaxPosition());
    }

    private Winners winners(Position maxPosition) {
        Winners winners = new Winners();
        for (Car car : this.cars) {
            if (car.isWinner(maxPosition)) {
                winners.addWinner(car);
            }
        }
        return winners;
    }

    private Position getMaxPosition() {
        Position maxPosition = new Position();
        for (Car car : this.cars) {
            maxPosition = car.maxPosition(maxPosition);
        }
        return maxPosition;
    }

}
