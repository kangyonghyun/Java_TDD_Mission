package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DefaultLottoGenerator implements LottoGenerator {

    private final Map<String, LottoGenerator> generators = new HashMap<>();

    public DefaultLottoGenerator(String manual, Money auto) {
        generators.put("manual", new LottoManualGenerator(manual));
        generators.put("auto", new LottoAutoGenerator(auto));
    }

    @Override
    public List<Lotto> generate() {
        List<Lotto> total = new ArrayList<>();
        for (String key : generators.keySet()) {
            total.addAll(generators.get(key).generate());
        }
        return total;
    }

}
