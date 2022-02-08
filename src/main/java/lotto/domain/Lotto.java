package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final String ERROR_SIX_RANGE_OF_NUMBERS_MSG = "6자리 입력해주세요";
    private final Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new IllegalArgumentException(ERROR_SIX_RANGE_OF_NUMBERS_MSG);
        }
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(List<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
        return new Lotto(lottoNumbers);
    }

    public int match(Lotto target) {
        int count = 0;
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            count += target.increment(lottoNumber);
        }
        return count;
    }

    private int increment(LottoNumber lottoNumber) {
        if (this.lottoNumbers.contains(lottoNumber)) {
            return 1;
        }
        return 0;
    }

    public boolean containBonusNo(LottoNumber bonusNo) {
        return this.lottoNumbers.contains(bonusNo);
    }

    public static Lotto ofComma(String value) {
        String[] values = value.split(",");
        return new Lotto(
                Arrays.stream(values)
                        .map(LottoNumber::of)
                        .collect(Collectors.toSet()));
    }

    public Set<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "" + lottoNumbers;
    }

}
