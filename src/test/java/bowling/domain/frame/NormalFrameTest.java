package bowling.domain.frame;

import bowling.domain.Board;
import bowling.domain.Score;
import bowling.domain.exception.CannotCalculateException;
import bowling.domain.state.State;
import bowling.domain.state.StateFactory;
import bowling.domain.state.Strike;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NormalFrameTest {

    NormalFrame current;

    @BeforeEach
    void setUp() {
        current = new NormalFrame(1);
    }

    @Test
    @DisplayName("NormalFrame 객체 생성")
    void create() {
        State ready = StateFactory.ready();
        NormalFrame current = new NormalFrame(1, ready);

        assertThat(current).isEqualTo(new NormalFrame(1, ready));
    }

    @Test
    @DisplayName("첫 투구가 스트라이크 아닐 경우 : ready -> FirstBowl")
    void bowl_9_this_frame() {
        // 같은 NormalFrame 객체 반환
        Frame next = current.bowl(9);

        assertThat(current.getNo()).isEqualTo(1);
        assertThat(current.getState()).isEqualTo(StateFactory.firstBowl(9));
        assertThat(current.getNext()).isNull();
        assertThat(next).isEqualTo(current);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2})
    @DisplayName("첫 투구가 스트라이크 아닐 경우 : ready -> FirstBowl -> (Miss, Spare)")
    void bowl_8_1_this_frame(int second) {
        //MISS or SPARE
        Frame next = current
                .bowl(8)
                .bowl(second);

        assertThat(current.getNo()).isEqualTo(1);
        assertThat(current.getState()).isEqualTo(StateFactory.firstBowl(8).bowl(second));
        assertThat(current.getNext()).isEqualTo(new NormalFrame(2));
        assertThat(next).isEqualTo(new NormalFrame(2));
    }

    @Test
    @DisplayName("첫 투구가 스트라이크일 경우 : ready -> FirstBowl -> Strike")
    void bowl_strike_next_frame() {
        // STRIKE
        Frame next = current.bowl(10);

        assertThat(current.getNo()).isEqualTo(1);
        assertThat(current.getState()).isExactlyInstanceOf(Strike.class);
        assertThat(current.getNext()).isEqualTo(new NormalFrame(2));
        assertThat(next).isEqualTo(new NormalFrame(2));
    }

    @ParameterizedTest
    @MethodSource("providedFrame")
    @DisplayName("점수 계산 못하는 경우 :Ready, FirstBowl, Spare, Strike")
    void x_getScore(Frame frame) {
        assertThatThrownBy(frame::calculateScore)
                .isInstanceOf(CannotCalculateException.class);
    }

    private static Stream<Arguments> providedFrame() {
        Frame ready = new NormalFrame(1);
        Frame firstBowl = new NormalFrame(1);
        Frame spare = new NormalFrame(1);
        Frame strike = new NormalFrame(1);

        firstBowl.bowl(7);
        spare.bowl(7).bowl(3);
        strike.bowl(10);

        return Stream.of(
                Arguments.of(ready),
                Arguments.of(firstBowl),
                Arguments.of(spare),
                Arguments.of(strike)
        );
    }

    @Test
    @DisplayName("Miss 점수")
    void miss_getScore() {
        current.bowl(7).bowl(2);
        assertThat(current.calculateScore()).isEqualTo(Score.miss(9));
    }

    @Test
    @DisplayName("Spare - miss 점수")
    void spare_miss_getScore() {
        current.bowl(7).bowl(3)
                .bowl(7).bowl(2);
        assertThat(current.calculateScore()).isEqualTo(new Score(17, 0));
    }

    @Test
    @DisplayName("Spare - Spare 점수")
    void spare_spare_getScore() {
        current.bowl(7).bowl(3)
                .bowl(7).bowl(3);
        assertThat(current.calculateScore()).isEqualTo(new Score(17, 0));
    }

    @Test
    @DisplayName("Strike - miss 점수")
    void strike_miss_getScore() {
        current.bowl(10)
                .bowl(7).bowl(2);
        assertThat(current.calculateScore()).isEqualTo(new Score(19, 0));
    }

    @Test
    @DisplayName("Strike - Strike -Strike 점수")
    void strike_strike_strike_getScore() {
        current.bowl(10)
                .bowl(10)
                .bowl(10);
        assertThat(current.calculateScore()).isEqualTo(new Score(30, 0));
    }

    @Test
    @DisplayName("현재상태(spare) : before - strike")
    void strike_calculateExtraScore() {
        current.bowl(8).bowl(2);
        assertThat(current.calculateExtraScore(Score.strike())).isEqualTo(new Score(20, 0));
    }

    @Test
    @DisplayName("현재상태(spare) : before - spare")
    void spare_calculateExtraScore() {
        current.bowl(8).bowl(2); // 현재상태 (spare)
        assertThat(current.calculateExtraScore(Score.spare())).isEqualTo(new Score(18, 0));
    }

    // 현재상태(strike, miss)
    @Test
    @DisplayName("현재상태(strike) : before - spare")
    void spare_strike_calculateExtraScore() {
        current.bowl(10);
        assertThat(current.calculateExtraScore(Score.spare())).isEqualTo(new Score(20, 0));
    }

    @Test
    @DisplayName("현재상태(strike) : before - strike")
    void strike_strike_calculateExtraScore() {
        current.bowl(10)
        .bowl(10);
        assertThat(current.calculateExtraScore(Score.strike())).isEqualTo(new Score(30, 0));
    }

    @Test
    @DisplayName("보드 생성 후 FrameResult 값 저장")
    void addFrameResult() {
        current.bowl(7).bowl(3)    //result - 17
                .bowl(7).bowl(1)              //result - 25
                .bowl(10)                     //result - 44
                .bowl(8).bowl(1);             //result - 53
                                          //result(-1) - 0 - !isFinal()
        Board board = current.createBoard();

        assertThat(board.getResults()).size().isEqualTo(5);
        assertThat(board.getGameScore()).isEqualTo(53);
    }

}