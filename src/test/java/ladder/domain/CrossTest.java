package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrossTest {

    @Test
    @DisplayName("첫 크로스 생성")
    void first_create() {
        Cross first = Cross.first(true);
        assertThat(first.getIndex()).isEqualTo(0);
        assertThat(first.getPoint()).isEqualTo(Point.first(true));
    }

    @Test
    @DisplayName("true : next() -> true, false / false : next() -> false / ??(random)")
    void next() {
        Cross next = Cross.first(true).next();
        assertThat(next.getIndex()).isEqualTo(1);
        assertThat(next.getPoint()).isEqualTo(Point.first(true).next(false));
    }

    @Test
    void move_right() {
        Cross cross = Cross.first(true);
        assertThat(cross.move()).isEqualTo(1);
    }

    @Test
    void move_south() {
        Cross cross = Cross.first(false);
        assertThat(cross.move()).isEqualTo(0);
    }

    @Test
    void move_left() {
        // cross (1, true, false)
        Cross cross =  Cross.first(true).next(false);
        assertThat(cross.move()).isEqualTo(0);
    }

}