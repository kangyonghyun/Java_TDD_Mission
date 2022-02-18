package bowling.domain.state;

import bowling.domain.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MissTest {

    private State miss;

    @BeforeEach
    void setUp() {
        miss = StateFactory.firstBowl(8).bowl(1);
    }

    @Test
    void create() {
        assertThat(miss).isEqualTo(new Miss(Pins.of(8), Pins.of(1)));
    }

    @Test
    void invalid_create() {
        assertThatThrownBy(() -> new Miss(Pins.of(8), Pins.of(3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getScore() {
        assertThat(miss.getScore()).isEqualTo(new Score(9, 0));
    }

    @Test
    @DisplayName("Miss 상태에서 spare 추가 점수 구하기")
    void calculateExtraScore() {
        Score score = miss.calculateExtraScore(Score.spare());
        assertThat(score).isEqualTo(new Score(18 , 0));
    }

    @Test
    @DisplayName("Miss 상태에서 strike 추가 점수 구하기")
    void calculateExtraScore1() {
        Score score = miss.calculateExtraScore(Score.strike());
        assertThat(score).isEqualTo(new Score(19 , 0));
    }

}