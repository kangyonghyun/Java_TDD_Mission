package racingcar.domain;

import racingcar.domain.strategy.MovingStrategy;

import java.util.Objects;

public class RacingGame {

    private final Cars cars;
    private final TryNo tryNo;
    private final MovingStrategy strategy;

    public RacingGame(Cars cars, int tryNo, MovingStrategy strategy) {
        this.cars = cars;
        this.tryNo = new TryNo(tryNo);
        this.strategy = strategy;
    }

    public RacingGame race() {
        Cars cars = this.cars.moveCars(this.strategy);
        int no = tryNo.race();
        return new RacingGame(cars, no, this.strategy);
    }

    public Winners findWinners() {
        return this.cars.findWinners();
    }

    public boolean isEndGame() {
        return this.tryNo.isZero();
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
        return Objects.equals(cars, that.cars) && Objects.equals(tryNo, that.tryNo) && Objects.equals(strategy, that.strategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, tryNo, strategy);
    }

}
