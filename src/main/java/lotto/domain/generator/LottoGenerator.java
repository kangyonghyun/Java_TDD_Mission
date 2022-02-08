package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.List;

public interface LottoGenerator {

    List<Lotto> generate(Money money);

}
