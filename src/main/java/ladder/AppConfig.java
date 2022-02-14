package ladder;

import ladder.domain.generator.DefaultLadderCreator;
import ladder.domain.generator.DefaultLineCreator;
import ladder.domain.generator.LadderCreator;
import ladder.domain.generator.LineCreator;

public class AppConfig {

    public LadderCreator ladderCreator() {
        return new DefaultLadderCreator(lineCreator());
    }

    public LineCreator lineCreator() {
        return new DefaultLineCreator();
    }

}
