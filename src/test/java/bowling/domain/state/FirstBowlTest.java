package bowling.domain.state;

import bowling.domain.Score;
import bowling.domain.exception.CannotCalculateException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class FirstBowlTest {

    private State firstBowl;

    @BeforeEach
    void setUp() {
        firstBowl = StateFactory.firstBowl(8);
    }

    @Test
    void create() {
        assertThat(firstBowl).isEqualTo(new FirstBowl(Pins.of(8)));
    }

    @Test
    @DisplayName("FirstBowl -> Miss")
    void miss() {
        assertThat(firstBowl.bowl(1)).isEqualTo(new Miss(Pins.of(8), Pins.of(1)));
    }

    @Test
    @DisplayName("FirstBowl -> Spare")
    void spare() {
        assertThat(firstBowl.bowl(2)).isEqualTo(new Spare(Pins.of(8), Pins.of(2)));
    }

    @Test
    @DisplayName("FirstBowl 상태에서 스페어 추가 득점구하기")
    void calculateExtraScore() {
        Score score = firstBowl.calculateExtraScore(Score.spare());
        assertThat(score).isEqualTo(new Score(18, 0));
    }

    @Test
    @DisplayName("FirstBowl 상태에서 (스트라이크,미스) 추가 득점구하기 -> CannotCalculateException 예외 반환")
    void invalid_calculateExtraScore() {
        assertThatThrownBy(() -> firstBowl.calculateExtraScore(Score.strike()))
                .isInstanceOf(CannotCalculateException.class);
    }

}