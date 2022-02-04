package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void create_1_45_o(int actual) {
        LottoNumber lottoNumber = LottoNumber.of(actual);
        assertThat(lottoNumber).isEqualTo(LottoNumber.of(actual));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void create_1_45_x(int actual) {
        assertThatThrownBy(() -> LottoNumber.of(actual))
                .isInstanceOf(IllegalArgumentException.class);
    }

}