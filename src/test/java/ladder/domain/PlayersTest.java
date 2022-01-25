package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayersTest {

    @Test
    void create() {
        List<String> names = Arrays.asList("kang", "pobi", "kesun");
        Players players = new Players(names);
        assertThat(players).isEqualTo(new Players(names));
    }

}