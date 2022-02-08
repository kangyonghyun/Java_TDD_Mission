package lotto.domain.generator;

import lotto.domain.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoManualGeneratorTest {

    @Test
    void generate() {
        String manualLottos = "1,2,3,4,5,6"
                                + "\r\n"
                                + "2,3,4,5,6,7"
                                + "\r\n"
                                + "11,12,13,14,15,16";
        LottoGenerator generator = new LottoManualGenerator(manualLottos);
        assertThat(generator.generate(new Money(3000))).size().isEqualTo(3);

    }

}