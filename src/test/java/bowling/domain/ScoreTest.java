package bowling.domain;

import bowling.domain.exception.CannotCalculateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ScoreTest {

    private Score strike;
    private Score spare;
    private Score miss;

    @BeforeEach
    void setUp() {
        strike = Score.strike();
        spare = Score.spare();
        miss = Score.miss(8);
    }

    @Test
    void create() {
        Score score = new Score(10, 0);
        assertThat(score).isEqualTo(new Score(10, 0));
    }

    @Test
    @DisplayName("정적 메소드 테스트")
    void miss() {
        assertThat(miss).isEqualTo(new Score(8, 0));
        assertThat(strike).isEqualTo(new Score(10, 2));
        assertThat(spare).isEqualTo(new Score(10, 1));
    }

    @Test
    @DisplayName("left == 0 -> true")
    void canCalculateScore() {
        assertThat(strike.canCalculateScore()).isFalse();
        assertThat(spare.canCalculateScore()).isFalse();
        assertThat(miss.canCalculateScore()).isTrue();
    }

    @Test
    @DisplayName("bowl() 호출 시 -> + 스코어, left - 1")
    void bowl() {
        assertThat(strike.bowl(5)).isEqualTo(new Score(15, 1));
        assertThat(spare.bowl(5)).isEqualTo(new Score(15, 0));
    }

    @Test
    @DisplayName("miss(left=0) 스코어에서 bowl() -> IllegalArgumentException 반환")
    void not_bowl() {
        assertThatThrownBy(() -> miss.bowl(5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("left==0 인 score 객체만 스코어 반환")
    void getScore() {
        assertThat(miss.getTotalScore()).isEqualTo(8);
    }

    @Test
    @DisplayName("left!=0 인 score 객체가 getScore() 호출 -> CannotCalculateException 반환")
    void invalid_getScore() {
        assertThatThrownBy(() -> strike.getTotalScore())
                .isInstanceOf(CannotCalculateException.class);
        assertThatThrownBy(() -> spare.getTotalScore())
                .isInstanceOf(CannotCalculateException.class);
    }

}