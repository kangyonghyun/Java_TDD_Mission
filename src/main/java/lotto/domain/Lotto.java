package lotto.domain;

import java.util.*;
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
        return this.lottoNumbers.stream()
                .mapToInt(target::increment)
                .sum();
    }

    private int increment(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber) ? 1 : 0;
    }

    public boolean containBonusNo(LottoNumber bonusNo) {
        return this.lottoNumbers.contains(bonusNo);
    }

    public static Lotto ofComma(String value) {
        Set<LottoNumber> numbers = Arrays.stream(value.split(","))
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
        return new Lotto(numbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(this.lottoNumbers);
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
