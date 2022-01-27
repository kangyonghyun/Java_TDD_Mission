package ladder.domain.util;

import java.util.Random;

public class RandomGenerator {

    private static final Random random = new Random();

    public static boolean generateRandom() {
        return random.nextBoolean();
    }

}
