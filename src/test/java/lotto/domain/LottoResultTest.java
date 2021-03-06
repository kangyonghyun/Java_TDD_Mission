package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    void create() {
        LottoResult result = new LottoResult();
        assertThat(result).isEqualTo(new LottoResult());
        assertThat(result.getResults()).size().isEqualTo(6);
    }

    @Test
    void putRank() {
        LottoResult result = new LottoResult();
        result.putRank(Rank.MISS);
        result.putRank(Rank.MISS);
        result.putRank(Rank.MISS);
        assertThat(result.getResults().get(Rank.MISS)).isEqualTo(3);
    }

    @Test
    void getPrize() {
        LottoResult result = new LottoResult();
        result.putRank(Rank.MISS);
        result.putRank(Rank.FIFTH);
        result.putRank(Rank.FIRST);
        assertThat(result.getTotalPrize()).isEqualTo(new Money(2_000_005_000));
    }

}