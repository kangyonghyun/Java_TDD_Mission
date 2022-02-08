package lotto.domain;

import java.util.Objects;

public class Money {

    private final int price;

    public Money(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("마이너스 금액은 안됩니다!");
        }
        this.price = price;
    }

    public int countOfBuyingLotto() {
        return this.price / 1000;
    }

    public Money buyManual(int countOfManual) {
        return new Money(this.price - (countOfManual * 1000));
    }

    public Money sum(Money prize) {
        return new Money(this.price + prize.price);
    }

    public double profitRate(Money prize) {
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
