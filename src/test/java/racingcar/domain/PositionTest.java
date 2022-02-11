package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PositionTest {

    @Test
    void o_create() {
        Position position = new Position();
        assertThat(position).isEqualTo(new Position());
    }

    @Test
    void x_create() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void isMoreThan() {
        Position position = new Position(3);
        assertThat(position.isMoreThan(new Position(2))).isTrue();
    }

    @Test
    void isSame() {
        Position position = new Position(3);
        assertThat(position.isSame(new Position(3))).isTrue();
    }

}