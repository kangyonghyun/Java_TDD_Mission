package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LadderCreatorTest {

    @Test
    void create_ladder() {
        LineCreator lineCreator = new LineCreator();
        LadderCreator ladderCreator = new LadderCreator(lineCreator);

        Ladder ladder = ladderCreator.createLadder(5, 4);

        assertThat(ladder.getLines()).size().isEqualTo(5);
        assertThat(ladder.getWidth()).isEqualTo(4);
    }


}