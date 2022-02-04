package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    void create() {
        LottoResult result = new LottoResult();
        assertThat(result.getResults()).size().isEqualTo(6);
        for (Rank rank : Rank.values()) {
            assertThat(result.getResults().get(rank)).isEqualTo(0);
        }
    }

    @Test
    void putRank() {
        LottoResult result = new LottoResult();
        result.putRank(Rank.MISS);
        assertThat(result.getResults().get(Rank.MISS)).isEqualTo(1);
    }

}