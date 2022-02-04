package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MoneyTest {

    @Test
    void count() {
        Money money = new Money(14000);
        int count = money.countOfBuyingLotto();
        assertThat(count).isEqualTo(14);
    }

    @Test
    @DisplayName("1000원 입력하면 정상")
    void orderPrice_o() {
        assertThatCode(() -> new Money(1000))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("1000원 미만 입력하면 IllegalArgumentException 반환")
    void orderPrice_x() {
        assertThatThrownBy(() -> new Money(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

}