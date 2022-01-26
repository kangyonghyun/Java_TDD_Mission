package ladder;

import ladder.domain.LadderCreator;
import ladder.domain.LineCreator;

public class AppConfig {

    public LadderCreator ladderCreator() {
        return new LadderCreator(new LineCreator());
    }

}
