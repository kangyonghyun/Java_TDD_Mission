package lotto.domain;

import java.util.Objects;

public class Money {

    public static final int PRICE_PER_LOTTO = 1000;
    public static final int MIN_PRICE = 0;
    private final int price;

    public Money(int price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException("마이너스 금액은 안됩니다!");
        }
        this.price = price;
    }

    public int countOfBuyingLotto() {
        return this.price / PRICE_PER_LOTTO;
    }

    public Money buyManual(int countOfManual) {
        return new Money(this.price - (countOfManual * PRICE_PER_LOTTO));
    }

    public Money sum(Money prize) {
        return new Money(this.price + prize.price);
    }

    public double profitRate(Money prize) {
        if (this.price == 0) {
            throw new IllegalArgumentException("금액이 0원일 경우 계산할 수 없습니다");
        }
        return prize.price / this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Money money = (Money) o;
        return price == money.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

}
