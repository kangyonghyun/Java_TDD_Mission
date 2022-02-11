package lotto.domain.generator;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoManualGenerator implements LottoGenerator {

    private final String inputManualLotteries;

    public LottoManualGenerator(String inputManualLotteries) {
        this.inputManualLotteries = inputManualLotteries;
    }

    @Override
    public List<Lotto> generate() {
        return generateLotteries(this.inputManualLotteries);
    }

    private List<Lotto> generateLotteries(String inputLotteries) {
        if (inputLotteries.equals("")) {
            return new ArrayList<>();
        }
        return Arrays.stream(inputLotteries.split("\r?\n"))
                .map(Lotto::ofComma)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoManualGenerator that = (LottoManualGenerator) o;
        return Objects.equals(inputManualLotteries, that.inputManualLotteries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inputManualLotteries);
    }

}
