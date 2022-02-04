package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class WiningLottoTest {

    @Test
    void create() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNo = LottoNumber.of(10);
        assertThatCode(() -> new WiningLotto(lotto, bonusNo))
                .doesNotThrowAnyException();
    }

    @Test
    void invalid_create() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNo = LottoNumber.of(6);
        assertThatThrownBy(() -> new WiningLotto(lotto, bonusNo))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void match() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNo = LottoNumber.of(10);
        WiningLotto winingLotto = new WiningLotto(lotto, bonusNo);
        Rank rank = winingLotto.match(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

}