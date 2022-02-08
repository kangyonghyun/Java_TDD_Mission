package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoAutoGenerator implements LottoGenerator {

    @Override
    public List<Lotto> generate(Money money) {
        List<Lotto> lotteries = new ArrayList<>();
        for (int i = 0; i < money.countOfBuyingLotto(); i++) {
            lotteries.add(generateRandomNumber());
        }

        return lotteries;
    }

    private Lotto generateRandomNumber() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            randomNumbers.add(i);
        }
        Collections.shuffle(randomNumbers);

        return Lotto.of(randomNumbers.subList(0, 6));
    }

}
