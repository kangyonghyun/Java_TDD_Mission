package lotto.domain;

import lotto.domain.generator.LottoGenerator;

import java.util.List;

public class LottoGame {

    private final List<Lotto> lotteries;

    public LottoGame(List<Lotto> lotteries) {
        this.lotteries = lotteries;
    }

    public LottoGame(Money money, LottoGenerator generator) {
        this.lotteries = generator.generate(money);
    }

    public LottoResult match(WiningLotto winingLotto) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lottery : lotteries) {
            lottoResult.putRank(winingLotto.match(lottery));
        }
        return lottoResult;
    }

    @Override
    public String toString() {
        return "LottoGame{" +
                "lotteries=" + lotteries +
                '}';
    }

}
