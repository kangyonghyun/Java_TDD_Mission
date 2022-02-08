package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.List;
import java.util.Map;

public class DefaultLottoGenerator implements LottoGenerator {

    private final Map<String, LottoGenerator> generatorMap;

    public DefaultLottoGenerator(Map<String, LottoGenerator> generatorMap) {
        this.generatorMap = generatorMap;
    }

    @Override
    public List<Lotto> generate(Money money) {
        LottoGenerator manual = generatorMap.get("manual");
        LottoGenerator auto = generatorMap.get("auto");

        List<Lotto> manuals = manual.generate(money);
        Money autoMoney = money.buyManual(manuals.size());
        List<Lotto> autos = auto.generate(autoMoney);

        manuals.addAll(autos);
        return manuals;
    }

}
