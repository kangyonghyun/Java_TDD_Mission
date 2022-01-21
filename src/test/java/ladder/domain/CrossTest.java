package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrossTest {

    @Test
    void move_right() {
        Point first = Point.first(true);
        Cross cross = new Cross(1, first);
        assertThat(cross.move()).isEqualTo(2);
    }

    @Test
    void move_south() {
        Point first = Point.first(false);
        Cross cross = new Cross(1, first);
        assertThat(cross.move()).isEqualTo(1);
    }

    @Test
    void move_left() {
        Point next = Point.first(true).next(false);
        Cross cross = new Cross(2, next);
        assertThat(cross.move()).isEqualTo(1);
    }

}