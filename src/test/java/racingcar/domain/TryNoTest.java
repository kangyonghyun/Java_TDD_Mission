package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryNoTest {

    @Test
    void o_create() {
        TryNo no = new TryNo(1);
        assertThat(no).isEqualTo(new TryNo(1));
    }

    @Test
    void x_create() {
        assertThatThrownBy(() -> new TryNo(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

}