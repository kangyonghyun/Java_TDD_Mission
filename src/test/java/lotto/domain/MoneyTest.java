package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    void create() {
        assertThatCode(() -> new Money(0))
                .doesNotThrowAnyException();
    }

    @Test
    void no_create() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void countOfBuyingLotto() {
        Money money = new Money(14000);
        assertThat(money.countOfBuyingLotto()).isEqualTo(14);
    }

    @Test
    void countOfBuyingLotto_zero() {
        Money money = new Money(999);
        assertThat(money.countOfBuyingLotto()).isEqualTo(0);
    }

    @Test
    void buyManual() {
        Money money = new Money(14000);
        assertThat(money.buyManual(3)).isEqualTo(new Money(11000));
    }

    @Test
    void no_buyManual() {
        Money money = new Money(14000);
        assertThatThrownBy(() -> money.buyManual(15))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void sum() {
        Money money = new Money(5_000);
        Money prize = new Money(50_000);
        assertThat(money.sum(prize)).isEqualTo(new Money(55_000));
    }

    @Test
    void profitRate() {
        Money orderMoney = new Money(14_000);
        Money prize = new Money(50_000);
        assertThat(orderMoney.profitRate(prize)).isEqualTo(50_000 / 14_000);
    }

}