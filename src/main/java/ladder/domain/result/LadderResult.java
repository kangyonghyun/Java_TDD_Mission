package ladder.domain.result;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {

    private static final String ERROR_NOT_KEY_MSG = "결과 값이 존재하지 않습니다";

    private final Map<Integer, Integer> result = new HashMap<>();

    public void put(int key, int value) {
        this.result.put(key, value);
    }

    public Map<Integer, Integer> getResult() {
        return this.result;
    }

    public int getOneResult(int key) {
        if (this.result.get(key) == null) {
            throw new IllegalArgumentException(ERROR_NOT_KEY_MSG);
        }
        return this.result.get(key);
    }

    public List<Integer> getAllResult() {
        List<Integer> all = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            all.add(getOneResult(i));
        }
        return all;
    }

}
