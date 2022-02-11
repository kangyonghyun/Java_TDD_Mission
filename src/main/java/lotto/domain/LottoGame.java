package lotto.domain;

import lotto.domain.generator.LottoGenerator;

import java.util.List;
import java.util.Objects;

public class LottoGame {

    private final List<Lotto> lotteries;

    public LottoGame(LottoGenerator generator) {
        this.lotteries = generator.generate();
    }

    public LottoResult match(WiningLotto winingLotto) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lottery : lotteries) {
            lottoResult.putRank(winingLotto.match(lottery));
        }
        return lottoResult;
    }

    public List<Lotto> getLotteries() {
        return this.lotteries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(lotteries, lottoGame.lotteries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteries);
    }

    @Override
    public String toString() {
        return "LottoGame{" +
                "lotteries=" + lotteries +
                '}';
    }

}
