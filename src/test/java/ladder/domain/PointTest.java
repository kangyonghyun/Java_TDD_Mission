package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PointTest {

    @Test
    void first() {
        Point first = Point.first(true);
        assertThat(first.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void next() {
        Point first = Point.first(true);
        Point next = first.next();
        assertThat(next.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void next_left() {
        Point next = Point.first(true).next(false);
        assertThat(next.move()).isEqualTo(Direction.LEFT);
    }

    @Test
    void next_right() {
        Point next = Point.first(false).next(true);
        assertThat(next.move()).isEqualTo(Direction.RIGHT);
    }

    @Test
    void next_south() {
        Point next = Point.first(false).next(false);
        assertThat(next.move()).isEqualTo(Direction.SOUTH);
    }

    @Test
    void next_invalid() {
        assertThatThrownBy(() -> Point.first(true).next(true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void last() {
        Point last = Point.first(true).next(false).last();
        assertThat(last.move()).isEqualTo(Direction.SOUTH);
    }

}