package ladder;

import ladder.controller.LadderController;
import ladder.domain.LadderCreator;

public class LadderApp {

    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        LadderCreator ladderCreator = config.ladderCreator();

        LadderController controller = new LadderController(ladderCreator);
        controller.start();
    }

}
