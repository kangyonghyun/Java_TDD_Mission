package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoAutoGenerator implements LottoGenerator {

    private final Money money;

    public LottoAutoGenerator(Money money) {
        this.money = money;
    }

    @Override
    public List<Lotto> generate() {
        return IntStream.range(0, this.money.countOfBuyingLotto())
                .mapToObj(range -> generateRandomNumber())
                .collect(Collectors.toList());
    }

    private Lotto generateRandomNumber() {
        List<Integer> randomNumbers = IntStream
                .rangeClosed(LottoNumber.MIN_LOTTO_NUMBER, LottoNumber.MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        Collections.shuffle(randomNumbers);

        return Lotto.of(randomNumbers.subList(0, 6));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoAutoGenerator that = (LottoAutoGenerator) o;
        return Objects.equals(money, that.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }

}
