package ladder.domain.result;

import ladder.AppConfig;
import ladder.domain.Ladder;
import ladder.domain.generator.LadderCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LadderResultTest {

    LadderCreator ladderCreator;
    Ladder ladder;
    LadderResult result;

    @BeforeEach
    void setUp() {
        AppConfig appConfig = new AppConfig();
        ladderCreator = appConfig.ladderCreator();
        ladder = ladderCreator.createLadder(4, 5);
        result = ladder.play();
    }

    @Test
    void create() {
        LadderResult result = new LadderResult();
        assertThat(result).isEqualTo(new LadderResult());
    }

    @Test
    void getOne_o() {
        assertThatCode(() -> result.getOneResult(3))
                .doesNotThrowAnyException();
    }

    @Test
    void getOne_x() {
        assertThatThrownBy(() -> result.getOneResult(4))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getAll() {
        assertThat(result.getAllResult()).size().isEqualTo(4);
    }

}