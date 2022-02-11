package lotto.domain.generator;

import lotto.domain.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAutoGeneratorTest {

    @Test
    void create() {
        LottoGenerator generator = new LottoAutoGenerator(new Money(14000));
        assertThat(generator).isEqualTo(new LottoAutoGenerator(new Money(14000)));
    }

    @Test
    void generate() {
        LottoGenerator auto = new LottoAutoGenerator(new Money(14000));
        assertThat(auto.generate()).size().isEqualTo(14);
    }

    @Test
    void zero_generate() {
        LottoGenerator auto = new LottoAutoGenerator(new Money(999));
        assertThat(auto.generate()).size().isEqualTo(0);
    }

}