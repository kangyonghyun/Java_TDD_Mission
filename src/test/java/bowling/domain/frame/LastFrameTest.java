package bowling.domain.frame;

import bowling.domain.Board;
import bowling.domain.Score;
import bowling.domain.exception.CannotCalculateException;
import bowling.domain.exception.GameOverException;
import bowling.domain.state.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.ThrowableAssert.ThrowingCallable;

public class LastFrameTest {

    private LastFrame lastFrame;

    @BeforeEach
    void setUp() {
        lastFrame = new LastFrame();
    }

    @Test
    void create() {
        assertThat(lastFrame).isEqualTo(new LastFrame());
        assertThat(lastFrame.getNo()).isEqualTo(10);
        assertThat(lastFrame.getStates()).containsExactly(StateFactory.ready());
    }

    @Test
    @DisplayName("1 투구 -> FirstBowl")
    void first_bowl() {
        lastFrame.bowl(7);
        assertThat(lastFrame.getStates()).containsExactly(StateFactory.ready().bowl(7));
    }

    @Test
    @DisplayName("1,2 투구 Miss -> Miss")
    void miss_bowl() {
        lastFrame.bowl(8).bowl(1);
        assertThat(lastFrame.getStates()).containsExactly(new Miss(Pins.of(8), Pins.of(1)));
        assertThat(lastFrame.calculateScore()).isEqualTo(new Score(9, 0));
    }

    @Test
    @DisplayName("1,2 투구 Spare -> 3투구 FirstBowl")
    void spare_firstBowl_bowl() {
        lastFrame.bowl(8).bowl(2)
                .bowl(7);
        assertThat(lastFrame.getStates()).containsExactly(new Spare(Pins.of(8), Pins.of(2)), new FirstBowl(Pins.of(7)));
        assertThat(lastFrame.calculateScore()).isEqualTo(new Score(17, 0));
    }

    @Test
    @DisplayName("1,2 투구 Spare -> 3투구 Strike")
    void spare_strike_bowl() {
        lastFrame.bowl(8).bowl(2)
                .bowl(10);
        assertThat(lastFrame.getStates().get(0)).isEqualTo(new Spare(Pins.of(8), Pins.of(2)));
        assertThat(lastFrame.getStates().get(1)).isEqualToIgnoringGivenFields(Strike.class);
        assertThat(lastFrame.calculateScore()).isEqualTo(new Score(20, 0));
    }

    @Test
    @DisplayName("1투구 스트라이크 2,3투구 미스 -> Strike, Miss")
    void strike_miss_bowl() {
        lastFrame.bowl(10)
                .bowl(8).bowl(1);
        assertThat(lastFrame.getStates()).size().isEqualTo(2);
        assertThat(lastFrame.getStates().get(0)).isEqualToIgnoringGivenFields(Strike.class);
        assertThat(lastFrame.getStates().get(1)).isEqualTo(new Miss(Pins.of(8), Pins.of(1)));
        assertThat(lastFrame.calculateScore()).isEqualTo(new Score(19, 0));
    }

    @Test
    @DisplayName("1 투구 스트라이크 -> 2,3 투구 스페어 => Strike, Spare")
    void strike_spare_bowl() {
        lastFrame.bowl(10)
                .bowl(8).bowl(2);
        assertThat(lastFrame.getStates()).size().isEqualTo(2);
        assertThat(lastFrame.getStates().get(0)).isEqualToIgnoringGivenFields(Strike.class);
        assertThat(lastFrame.getStates().get(1)).isEqualTo(new Spare(Pins.of(8), Pins.of(2)));
        assertThat(lastFrame.calculateScore()).isEqualTo(new Score(20, 0));
    }

    @Test
    @DisplayName("1,2,3 투구 스트라이크 -> 상태리스트에 스트라이크 3개 들어있음")
    void strike_strike_strike_bowl() {
        lastFrame.bowl(10)
                .bowl(10)
                .bowl(10);
        assertThat(lastFrame.getStates()).size().isEqualTo(3);
        assertThat(lastFrame.getStates()).allMatch(s -> s.getClass() == Strike.class);
        assertThat(lastFrame.calculateScore()).isEqualTo(new Score(30, 0));
    }

    @Test
    @DisplayName("스트라이크 점수 넘어오고, Miss, Spare, Strike 상태에서는 추가점수 계산 ")
    void calculateExtraScore() {
        lastFrame.bowl(7).bowl(2);
        Score score = lastFrame.calculateExtraScore(Score.strike());
        assertThat(score).isEqualTo(new Score(19, 0));
    }

    @Test
    @DisplayName("스페어 점수 넘어오고, Miss, Spare, Strike 상태에서는 추가 점수 계산")
    void calculateExtraScore1() {
        lastFrame.bowl(7);
        Score score = lastFrame.calculateExtraScore(Score.spare());
        assertThat(score).isEqualTo(new Score(17, 0));
    }

    @Test
    @DisplayName("스트라이크 점수가 넘어왔는데 - FirstBowl 상태에서 계산했다 -> CannotCalculateException 반환")
    void invalid_calculateExtraScore() {
        lastFrame.bowl(7);
        assertThatThrownBy(() -> lastFrame.calculateExtraScore(Score.strike()))
                .isInstanceOf(CannotCalculateException.class);
    }

    @Test
    @DisplayName("스트라이크, 스페어 점수가 넘어왔는데 - Ready 상태에서 계산했다 -> CannotCalculateException 반환")
    void invalid_calculateExtraScore1() {
        assertThatThrownBy(() -> lastFrame.calculateExtraScore(Score.strike()))
                .isInstanceOf(CannotCalculateException.class);
        assertThatThrownBy(() -> lastFrame.calculateExtraScore(Score.spare()))
                .isInstanceOf(CannotCalculateException.class);
    }

    @ParameterizedTest
    @MethodSource("providedBowlForIsEndGame")
    @DisplayName("투구가 끝나고 투구할 경우 -> GameOverException 반환")
    void isEndGame(ThrowingCallable actual) {
        assertThatThrownBy(actual)
                .isInstanceOf(GameOverException.class);
    }

    private static Stream<Arguments> providedBowlForIsEndGame() {
        LastFrame lastFrame = new LastFrame();
        return Stream.of(
                Arguments.of((ThrowingCallable) () -> lastFrame.bowl(8).bowl(2).bowl(10).bowl(5)),
                Arguments.of((ThrowingCallable) () -> lastFrame.bowl(10).bowl(5).bowl(4).bowl(5)),
                Arguments.of((ThrowingCallable) () -> lastFrame.bowl(10).bowl(5).bowl(5).bowl(5)),
                Arguments.of((ThrowingCallable) () -> lastFrame.bowl(8).bowl(2).bowl(10).bowl(5)),
                Arguments.of((ThrowingCallable) () -> lastFrame.bowl(8).bowl(2).bowl(5).bowl(5)),
                Arguments.of((ThrowingCallable) () -> lastFrame.bowl(8).bowl(1).bowl(5))
        );
    }

    @ParameterizedTest
    @MethodSource("providedBowlForIsEndGame1")
    @DisplayName("Running(Ready, FirstBowl) 상태에서 getScore() 호출 시 -> CannotCalculateException 반환")
    void invalid_getScore(ThrowingCallable actual) {
        assertThatThrownBy(actual)
                .isInstanceOf(CannotCalculateException.class);
    }

    private static Stream<Arguments> providedBowlForIsEndGame1() {
        return Stream.of(
                Arguments.of((ThrowingCallable) () -> new LastFrame().calculateScore()),
                Arguments.of((ThrowingCallable) () -> new LastFrame().bowl(8).calculateScore()),
                Arguments.of((ThrowingCallable) () -> new LastFrame().bowl(10).bowl(5).calculateScore())
        );
    }

    @Test
    @DisplayName("board 에 FrameResult 값 저장")
    void addFrameResult() {
        lastFrame.bowl(10)
                .bowl(10)
                .bowl(10);
        Board board = new Board();
        lastFrame.addFrameResult(board);
        assertThat(board.getResults()).size().isEqualTo(1);
        assertThat(board.getGameScore()).isEqualTo(30);
    }

}
