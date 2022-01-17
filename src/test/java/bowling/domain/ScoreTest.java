package bowling.domain;

import bowling.domain.state.Strike;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    void create() {
        Score score = new Score(10, 0);
        assertThat(score).isEqualTo(new Score(10, 0));
    }

    @Test
    void miss() {
        assertThat(Score.miss(8)).isEqualTo(new Score(8, 0));
    }

    @Test
    void strike() {
        assertThat(Score.strike()).isEqualTo(new Score(10, 2));
    }

    @Test
    void spare() {
        assertThat(Score.spare()).isEqualTo(new Score(10, 1));
    }

    @Test
    void canCalculateScore() {
        Score strike = Score.strike();
        assertThat(strike.canCalculateScore()).isFalse();
        Score miss = Score.miss(8);
        assertThat(miss.canCalculateScore()).isTrue();
    }

    @Test
    void bowl() {
        Score score = Score.strike();
        Score result = score.bowl(5);
        assertThat(result).isEqualTo(new Score(15, 1));
    }

}