package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderResult {

    private final Map<Integer, Integer> result = new HashMap<>();

    public void put(int key, int value) {
        this.result.put(key, value);
    }

    public Map<Integer, Integer> getResult() {
        return this.result;
    }

    public int getOneResult(int one) {
        return this.result.get(one);
    }

    public List<Integer> getAllResult() {
        List<Integer> all = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            all.add(getOneResult(i));
        }
        return all;
    }

}
