package ladder.domain.generator;

import ladder.domain.Ladder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultLadderCreatorTest {

    @Test
    void create_ladder() {
        LineCreator lineCreator = new DefaultLineCreator();
        LadderCreator ladderCreator = new DefaultLadderCreator(lineCreator);

        Ladder ladder = ladderCreator.createLadder(4, 5);

        assertThat(ladder.getWidth()).isEqualTo(4);
        assertThat(ladder.getLines()).size().isEqualTo(5);

    }

}