package ladder.domain.generator;

import ladder.domain.Ladder;

public interface LadderCreator {

    Ladder createLadder(int height, int width);

}
