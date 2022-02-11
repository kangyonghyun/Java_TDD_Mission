package lotto.domain.generator;

import lotto.domain.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultLottoGeneratorTest {

    @Test
    void create() {
        String manualLotteries = "1,2,3,4,5,6"
                + "\r\n"
                + "2,3,4,5,6,7"
                + "\r\n"
                + "11,12,13,14,15,16";
        Money autoMoney = new Money(5000);
        LottoGenerator generator = new DefaultLottoGenerator(manualLotteries, autoMoney);
        assertThat(generator.generate()).size().isEqualTo(8);
    }

}