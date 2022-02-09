package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarNameTest {

    @Test
    void o_create() {
        CarName carName = new CarName("12345");
        assertThat(carName).isEqualTo(new CarName("12345"));
    }

    @Test
    void x_create() {
        assertThatThrownBy(() -> new CarName("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}