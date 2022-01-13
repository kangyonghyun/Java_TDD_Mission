package bowling.domain.frame;

import bowling.domain.state.State;
import bowling.domain.state.StateFactory;
import bowling.domain.state.Strike;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NormalFrameTest {

    @Test
    @DisplayName("no를 받아서 객체 생성 - 초기 상태 Ready")
    void create() {
        State ready = StateFactory.ready();
        NormalFrame normalFrame = new NormalFrame(1, ready);

        assertThat(normalFrame).isEqualTo(new NormalFrame(1, ready));
    }

    @Test
    @DisplayName("첫 투구가 스트라이크 아닐 경우 -> FirstBowl 상태 객체 반환")
    void bowl_9_this_frame() {
        NormalFrame normalFrame = new NormalFrame(1, StateFactory.ready());

        // 같은 NormalFrame 객체 반환
        Frame frame = normalFrame.bowl(9);

        assertThat(frame.getNo()).isEqualTo(1);
        assertThat(frame.getState()).isEqualTo(StateFactory.firstBowl(9));
    }

    @Test
    @DisplayName("첫 투구가 스트라이크일 경우 -> no+1, Strike 상태 객체 반환")
    void bowl_strike_next_frame() {
        State ready = StateFactory.ready();
        NormalFrame normalFrame = new NormalFrame(1, ready);

        // 다음 NormalFrame 객체 생성후 반환
        Frame frame = normalFrame.bowl(10);

        assertThat(normalFrame.getNo()).isEqualTo(1);
        assertThat(normalFrame.getState()).isEqualTo(new Strike(10));
        assertThat(frame.getNo()).isEqualTo(2);
        assertThat(frame.getState()).isEqualTo(ready);
    }


}