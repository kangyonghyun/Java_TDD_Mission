package ladder.domain.result;

import java.util.*;

public class LadderResult {

    private static final String ERROR_NOT_KEY_MSG = "결과 값이 존재하지 않습니다";

    private final Map<Integer, Integer> result = new HashMap<>();

    public void put(int key, int value) {
        this.result.put(key, value);
    }

    public int getOneResult(int key) {
        if (this.result.get(key) == null) {
            throw new IllegalArgumentException(ERROR_NOT_KEY_MSG);
        }
        return this.result.get(key);
    }

    public List<Integer> getAllResult() {
        return new ArrayList<>(this.result.values());
    }

    public Map<Integer, Integer> getResult() {
        return this.result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LadderResult that = (LadderResult) o;
        return Objects.equals(result, that.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }

    @Override
    public String toString() {
        return "LadderResult{" + result + '}';
    }

}
