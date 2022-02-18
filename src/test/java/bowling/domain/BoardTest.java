package bowling.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    void create() {
        assertThat(board).isEqualTo(new Board());
    }

    @Test
    @DisplayName("보드에 FrameResult 저장")
    void add_frameResult() {
        board.add(new FrameResult(9));
        assertThat(board.getGameScore()).isEqualTo(9);
        assertThat(board.getResults()).containsExactly(new FrameResult(9));
    }

    @Test
    @DisplayName("보드에 FrameResult 저장 -> 스코어 저장 x")
    void add_frameResult_isUnScore() {
        board.add(new FrameResult(-1));
        assertThat(board.getGameScore()).isEqualTo(0);
        assertThat(board.getResults()).containsExactly(new FrameResult(-1));
    }

}