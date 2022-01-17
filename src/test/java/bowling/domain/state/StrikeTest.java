package bowling.domain.state;

import bowling.domain.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StrikeTest {

    private Strike strike;

    @BeforeEach
    void setUp() {
        strike = new Strike();
    }

    @Test
    void getScore() {
        assertThat(strike.getScore()).isEqualTo(Score.strike());
    }

    @Test
    @DisplayName("Strike 상태에서 스페어 추가 점수 구하기")
    void calculateExtraScore() {
        Score score = strike.calculateExtraScore(Score.spare());
        assertThat(score).isEqualTo(new Score(20, 0));
    }

    @Test
    @DisplayName("Strike 상태에서 스트라이크 추가 점수 구하기")
    void calculateExtraScore1() {
        Score score = strike.calculateExtraScore(Score.strike());
        assertThat(score).isEqualTo(new Score(20, 1));
    }

}