package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    Map<Rank, Integer> results = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            this.results.put(rank, 0);
        }
    }

    public void putRank(Rank rank) {
        this.results.put(rank, results.get(rank) + 1);
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
