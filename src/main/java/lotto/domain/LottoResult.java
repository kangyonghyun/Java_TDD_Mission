package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoResult {

    private final Map<Rank, Integer> results = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            this.results.put(rank, 0);
        }
    }

    public void putRank(Rank rank) {
        this.results.put(rank, results.getOrDefault(rank, 0) + 1);
    }

    public Money getTotalPrize() {
        Money totalPrize = new Money(0);
        for (Rank rank : results.keySet()) {
            Money prizePerRank = rank.prize(results.get(rank));
            totalPrize = totalPrize.sum(prizePerRank);
        }
        return totalPrize;
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoResult result = (LottoResult) o;
        return Objects.equals(results, result.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }

    @Override
    public String toString() {
        return "LottoResult{" +
                "results=" + results +
                '}';
    }

}
