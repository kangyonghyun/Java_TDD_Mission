package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    @DisplayName("width 만큼 결과값이 Map 에 저장")
    void play() {
        LadderCreator ladderCreator = new LadderCreator(new LineCreator());
        Ladder ladder = ladderCreator.createLadder(5, 4);

        LadderResult result = ladder.play();

        assertThat(result.getResult().size()).isEqualTo(4);
    }

}