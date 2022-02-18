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
    @DisplayName("정적 메소드 테스트")
    void miss() {
        assertThat(miss).isEqualTo(Score.miss(8));
        assertThat(spare).isEqualTo(Score.spare());
        assertThat(strike).isEqualTo(Score.strike());
    }

    @Test
    @DisplayName("miss(left=0) 스코어에서 bowl() -> IllegalArgumentException 반환")
    void not_bowl() {
        assertThatThrownBy(() -> miss.bowl(5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("bowl() 호출 시 -> + 스코어, left - 1")
    void bowl() {
        Score result = strike.bowl(5);
        assertThat(result.getTotal()).isEqualTo(15);
        assertThat(result.getLeft()).isEqualTo(1);
    }

    @Test
    @DisplayName("left == 0 -> true")
    void canCalculateScore() {
        assertThat(strike.canCalculateScore()).isFalse();
        assertThat(spare.canCalculateScore()).isFalse();
        assertThat(miss.canCalculateScore()).isTrue();
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