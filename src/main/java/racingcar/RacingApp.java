package racingcar;

import racingcar.controller.RacingController;

public class RacingApp {

    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        RacingController controller = new RacingController(config.strategy());
        controller.play();
    }

}
