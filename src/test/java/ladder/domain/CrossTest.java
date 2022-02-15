package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrossTest {

    @Test
    void create() {
        Cross cross = Cross.first(true);
        assertThat(cross).isEqualTo(Cross.first(true));
    }

    @Test
    @DisplayName("첫 크로스 생성")
    void first_create() {
        Cross first = Cross.first(true);
        assertThat(first.getIndex()).isEqualTo(0);
        assertThat(first.getPoint()).isEqualTo(Point.first(true));
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

    @Test
    @DisplayName("true : next() -> true, false / false : next() -> false / ??(random)")
    void next() {
        Cross next = Cross.first(true).next();
        assertThat(next).isEqualTo(new Cross(1, Point.first(true).next(false)));
    }

    @Test
    @DisplayName("첫번째 Cross false 일 경우 next(true) 지정")
    void next1() {
        Cross next = Cross.first(false).next(true);
        assertThat(next).isEqualTo(new Cross(1, Point.first(true)));
    }

    @Test
    @DisplayName("첫번째 Cross false 일 경우 next(false) 지정")
    void next2() {
        Cross next = Cross.first(false).next(false);
        assertThat(next).isEqualTo(new Cross(1, Point.first(false)));
    }


}