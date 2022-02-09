package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> results = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            this.results.put(rank, 0);
        }
    }

    public void putRank(Rank rank) {
        this.results.put(rank, results.get(rank) + 1);
    }

    public Money getPrize() {
        Money prize = new Money(0);
        for (Rank rank : results.keySet()) {
            Money prizePerRank = rank.prize(results.get(rank));
            prize = prize.sum(prizePerRank);
        }
        return prize;
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "results=" + results +
                '}';
    }

}
