package racingcar.domain;

import racingcar.domain.strategy.MovingStrategy;

import java.util.Objects;

public class RacingGame {

    private final Cars cars;
    private final TryNo tryNo;

    public RacingGame(Cars cars, int tryNo) {
        this.cars = cars;
        this.tryNo = new TryNo(tryNo);
    }

    public RacingGame race(MovingStrategy strategy) {
        Cars cars = this.cars.moveCars(strategy);
        int remaining = this.tryNo.race();
        return new RacingGame(cars, remaining);
    }

    public Winners findWinners() {
        return this.cars.findWinners();
    }

    public boolean isEndGame() {
        return this.tryNo.isTryNoZero();
    }

    public Cars getCars() {
        return this.cars;
    }

    public TryNo getTryNo() {
        return this.tryNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RacingGame that = (RacingGame) o;
        return Objects.equals(cars, that.cars) && Objects.equals(tryNo, that.tryNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, tryNo);
    }

}
