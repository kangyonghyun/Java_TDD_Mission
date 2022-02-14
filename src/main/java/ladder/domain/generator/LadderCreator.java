package ladder.domain.generator;

import ladder.domain.Ladder;

public interface LadderCreator {

    Ladder createLadder(int width, int height);

}
