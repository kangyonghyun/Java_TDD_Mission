package lotto.domain.generator;

import lotto.domain.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoAutoGeneratorTest {

    @Test
    void generate() {
        LottoGenerator auto = new LottoAutoGenerator();
        assertThat(auto.generate(new Money(14000))).size().isEqualTo(14);
        assertThat(auto.generate(new Money(999))).size().isEqualTo(0);
    }

}