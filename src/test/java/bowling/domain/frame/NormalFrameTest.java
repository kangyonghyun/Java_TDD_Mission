package bowling.domain.frame;

import bowling.domain.Board;
import bowling.domain.FrameResult;
import bowling.domain.Score;
import bowling.domain.state.*;
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
        NormalFrame frame = (NormalFrame) normalFrame.bowl(9);

        assertThat(frame.getNo()).isEqualTo(1);
        assertThat(frame.getState()).isEqualTo(StateFactory.firstBowl(9));
    }

    @Test
    @DisplayName("첫 투구가 스트라이크 아닐 경우 -> FirstBowl -> Miss")
    void bowl_8_1_this_frame() {
        NormalFrame normalFrame = new NormalFrame(1, StateFactory.ready());

        //MISS
        normalFrame.bowl(8).bowl(1);

        assertThat(normalFrame.getNo()).isEqualTo(1);
        assertThat(normalFrame.getState()).isEqualTo(new Miss(new Pins(8), new Pins(1)));
    }

    @Test
    @DisplayName("첫 투구가 스트라이크 아닐 경우 -> FirstBowl -> Spare")
    void bowl_8_2_this_frame() {
        NormalFrame normalFrame = new NormalFrame(1, StateFactory.ready());

        //SPARE
        normalFrame.bowl(8).bowl(2);

        assertThat(normalFrame.getNo()).isEqualTo(1);
        assertThat(normalFrame.getState()).isEqualTo(new Spare(new Pins(8), new Pins(2)));
    }

    @Test
    @DisplayName("첫 투구가 스트라이크일 경우 -> no+1, Strike 상태 객체 반환")
    void bowl_strike_next_frame() {
        State ready = StateFactory.ready();
        NormalFrame normalFrame = new NormalFrame(1, ready);

        // 다음 NormalFrame 객체 생성후 반환
        NormalFrame frame = (NormalFrame) normalFrame.bowl(10);

        assertThat(normalFrame.getNo()).isEqualTo(1);
        assertThat(normalFrame.getState()).isExactlyInstanceOf(Strike.class);
        assertThat(frame.getNo()).isEqualTo(2);
        assertThat(frame.getState()).isEqualTo(ready);
    }

    @Test
    @DisplayName("현재상태(spare) : before - strike")
    void strike_calculateExtraScore() {
        Frame now = new NormalFrame(1);
        now.bowl(8).bowl(2);
        assertThat(now.calculateExtraScore(Score.strike())).isEqualTo(new Score(20, 0));
    }

    @Test
    @DisplayName("현재상태(spare) : before - spare")
    void spare_calculateExtraScore() {
        Frame now = new NormalFrame(1);
        now.bowl(8).bowl(2); // 현재상태 (spare)
        assertThat(now.calculateExtraScore(Score.spare())).isEqualTo(new Score(18, 0));
    }

    // 현재상태(strike, miss)
    @Test
    @DisplayName("현재상태(strike) : before - spare")
    void spare_strike_calculateExtraScore() {
        Frame now = new NormalFrame(1);
        now.bowl(10);
        assertThat(now.calculateExtraScore(Score.spare())).isEqualTo(new Score(20, 0));
    }

    @Test
    @DisplayName("현재상태(strike) : before - strike")
    void strike_strike_calculateExtraScore() {
        Frame now = new NormalFrame(1);
        now.bowl(10)
        .bowl(10);
        assertThat(now.calculateExtraScore(Score.strike())).isEqualTo(new Score(30, 0));
    }

    @Test
    @DisplayName("Miss 점수")
    void miss_getScore() {
        Frame now = new NormalFrame(1);
        now.bowl(7).bowl(2);
        assertThat(now.getScore()).isEqualTo(new Score(9, 0));
    }

    @Test
    @DisplayName("Spare - miss 점수")
    void spare_miss_getScore() {
        Frame now = new NormalFrame(1);
        now.bowl(7).bowl(3)
                .bowl(7).bowl(2);
        assertThat(now.getScore()).isEqualTo(new Score(17, 0));
    }

    @Test
    @DisplayName("Strike - miss 점수")
    void strike_miss_getScore() {
        Frame now = new NormalFrame(1);
        now.bowl(10)
                .bowl(7).bowl(2);
        assertThat(now.getScore()).isEqualTo(new Score(19, 0));
    }

    @Test
    @DisplayName("Strike - Strike -Strike 점수")
    void strike_strike_strike_getScore() {
        Frame now = new NormalFrame(1);
        now.bowl(10)
                .bowl(10)
                .bowl(10);
        assertThat(now.getScore()).isEqualTo(new Score(30, 0));
    }

    @Test
    @DisplayName("보드 생성 후 FrameResult 값 저장")
    void addFrameResult2() {
        NormalFrame now = new NormalFrame(1);
        now
                .bowl(7).bowl(3)    //result - 17
                .bowl(7).bowl(1)              //result - 25
                .bowl(10)                     //result - 44
                .bowl(8).bowl(1);             //result - 53
                                          //result(-1) - 0 - !isFinal()
        Board board = now.createBoard();

        assertThat(board.getResults()).size().isEqualTo(5);
        assertThat(board.getGameScore()).isEqualTo(53);
    }


}