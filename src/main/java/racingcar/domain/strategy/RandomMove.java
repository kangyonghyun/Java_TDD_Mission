package racingcar.domain.strategy;

import java.util.Random;

public class RandomMove implements MovingStrategy {

    private static final int MAX_RANDOM_VALUE = 10;

    private final static Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(MAX_RANDOM_VALUE);
    }

}
