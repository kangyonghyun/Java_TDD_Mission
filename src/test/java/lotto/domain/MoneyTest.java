package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    void create() {
        Money money = new Money(0);
        assertThat(money).isEqualTo(new Money(0));
        assertThatCode(() -> new Money(0))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("마이너스 금액 입력시 IllegalArgumentException 반환")
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
    void zero_countOfBuyingLotto() {
        Money money = new Money(999);
        assertThat(money.countOfBuyingLotto()).isEqualTo(0);
    }

    @Test
    void buyManual() {
        Money money = new Money(14000);
        assertThat(money.buyManual(3)).isEqualTo(new Money(11000));
    }

    @Test
    @DisplayName("돈을 초과하여 구매시 IllegalArgumentException 반환")
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

    @Test
    @DisplayName("0으로 나눌 수 없다 IllegalArgumentException 반환")
    void no_profitRate() {
        Money orderMoney = new Money(0);
        Money prize = new Money(50_000);
        assertThatThrownBy(() -> orderMoney.profitRate(prize))
                .isInstanceOf(IllegalArgumentException.class);
    }

}