package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoManualGenerator implements LottoGenerator {

    private final String inputManualLottos;

    public LottoManualGenerator(String inputManualLottos) {
        this.inputManualLottos = inputManualLottos;
    }

    @Override
    public List<Lotto> generate(Money money) {
        return generateLottos(this.inputManualLottos);
    }

    private List<Lotto> generateLottos(String inputLottos) {
        if (inputLottos.equals("")) {
            return new ArrayList<>();
        }
        return Arrays.stream(inputLottos.split("\r?\n"))
                .map(s -> Lotto.ofComma(s))
                .collect(Collectors.toList());
    }

}
