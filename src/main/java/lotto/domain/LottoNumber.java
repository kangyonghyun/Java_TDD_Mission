package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final Map<Integer, LottoNumber> lottoNumberCash = new HashMap<>();

    public static final int MIN_LOTTO_NUMBER = 1;

    public static final int MAX_LOTTO_NUMBER = 45;

    static {
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .forEach(num -> lottoNumberCash.put(num, new LottoNumber(num)));
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber of(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("1-45");
        }
        return lottoNumberCash.get(number);
    }

    public static LottoNumber of(String value) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException();
        }

        return of(Integer.parseInt(value.trim()));
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }


    @Override
    public String toString() {
        return "" + number;
    }

}
