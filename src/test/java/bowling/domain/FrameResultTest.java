package bowling.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FrameResultTest {

    @Test
    void create() {
        FrameResult frameResult = new FrameResult(9);
        assertThat(frameResult).isEqualTo(new FrameResult(9));
    }

    @Test
    void addTotalScore() {
        FrameResult frameResult = new FrameResult(9);
        int total = frameResult.addTotalScore(8);
        assertThat(total).isEqualTo(17);
        assertThat(frameResult.getTotalScore()).isEqualTo(17);
    }

    @Test
    void addTotalScore_isUnScore() {
        FrameResult frameResult = new FrameResult(-1);
        int total = frameResult.addTotalScore(9);
        assertThat(total).isEqualTo(-1);
    }

}