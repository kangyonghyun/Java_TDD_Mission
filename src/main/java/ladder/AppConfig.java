package ladder;

import ladder.domain.DefaultLadderCreator;
import ladder.domain.DefaultLineCreator;
import ladder.domain.LadderCreator;
import ladder.domain.LineCreator;

public class AppConfig {

    public LadderCreator ladderCreator() {
        return new DefaultLadderCreator(lineCreator());
    }

    public LineCreator lineCreator() {
        return new DefaultLineCreator();
    }

}
