package ladder.domain.result;

import ladder.AppConfig;
import ladder.domain.*;
import ladder.domain.generator.DefaultLadderCreator;
import ladder.domain.generator.DefaultLineCreator;
import ladder.domain.generator.LadderCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderResultTest {

    LadderCreator ladderCreator;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        ladderCreator = appConfig.ladderCreator();
    }

    @Test
    void getOne_o() {
        Ladder ladder = ladderCreator.createLadder(5, 4);
        LadderResult result = ladder.play();

        assertThat(result.getOneResult(3)).isNotNull();
    }

    @Test
    void getOne_x() {
        Ladder ladder = ladderCreator.createLadder(5, 4);
        LadderResult result = ladder.play();

        assertThatThrownBy(() -> result.getOneResult(4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getAll() {
        LadderCreator ladderCreator = new DefaultLadderCreator(new DefaultLineCreator());
        Ladder ladder = ladderCreator.createLadder(5, 4);
        LadderResult result = ladder.play();

        List<Integer> allResult = result.getAllResult();
        assertThat(allResult).size().isEqualTo(4);
    }

}