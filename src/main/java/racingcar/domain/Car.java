package racingcar.domain;

import java.util.Objects;

public class Car {

    private static final int MIN_MOVABLE_VALUE = 4;

    private final CarName carName;
    private final Position position;

    public static Car of(String name) {
        return new Car(name);
    }

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int position) {
        this(new CarName(carName), position);
    }

    public Car(CarName carName, int position) {
        this.carName = carName;
        this.position = new Position(position);
    }

    public Car move(int randomNumber) {
        if (randomNumber >= MIN_MOVABLE_VALUE) {
            return move();
        }
        return this;
    }

    private Car move() {
        return new Car(this.carName, this.position.increment());
    }

    public Position maxPosition(Position maxPosition) {
        if (this.position.isMoreThan(maxPosition)) {
            return this.position;
        }
        return maxPosition;
    }

    public boolean isWinner(Position maxPosition) {
        return this.position.isSame(maxPosition);
    }

    public CarName getCarName() {
        return this.carName;
    }

    public Position getPosition() {
        return this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(carName, car.carName) && Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, position);
    }

}
