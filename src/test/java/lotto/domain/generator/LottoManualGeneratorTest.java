package lotto.domain.generator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoManualGeneratorTest {

    @Test
    void create() {
        LottoGenerator generator = new LottoManualGenerator("");
        assertThat(generator).isEqualTo(new LottoManualGenerator(""));
    }

    @Test
    void generate() {
        String manualLotteries = "1,2,3,4,5,6"
                                + "\r\n"
                                + "2,3,4,5,6,7"
                                + "\r\n"
                                + "11,12,13,14,15,16";
        LottoGenerator generator = new LottoManualGenerator(manualLotteries);
        assertThat(generator.generate()).size().isEqualTo(3);

    }

}