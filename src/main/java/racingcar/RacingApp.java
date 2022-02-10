package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.strategy.RandomMove;

public class RacingApp {

    public static void main(String[] args) {
        RacingController controller = new RacingController(new RandomMove());
        controller.play();
    }

}
