package bowling.domain.state;

import bowling.domain.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SpareTest {

    private Spare spare;

    @BeforeEach
    void setUp() {
        spare = new Spare(Pins.of(8), Pins.of(2));
    }

    @Test
    void create() {
        assertThat(spare).isEqualTo(new Spare(Pins.of(8), Pins.of(2)));
    }

    @Test
    void invalid_create() {
        assertThatThrownBy(() -> new Spare(Pins.of(8), Pins.of(3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getScore() {
        assertThat(spare.getScore()).isEqualTo(Score.spare());
    }

    @Test
    @DisplayName("Spare 상태에서 스페어 추가 득점 구하기")
    void calculateExtraScore() {
        Score result = spare.calculateExtraScore(Score.spare());
        assertThat(result).isEqualTo(new Score(18, 0));
    }

    @Test
    @DisplayName("Spare 상태에서 스트라이크 추가 득점 구하기")
    void calculateExtraScore1() {
        Score result = spare.calculateExtraScore(Score.strike());
        assertThat(result).isEqualTo(new Score(20, 0));
    }

}