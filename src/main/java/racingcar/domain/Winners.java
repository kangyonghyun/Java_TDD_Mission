package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {

    private final List<Car> winners;

    public Winners() {
        this(new ArrayList<>());
    }

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public void addWinner(Car winner) {
        this.winners.add(winner);
    }

    public List<Car> getWinners() {
        return winners;
    }

}
