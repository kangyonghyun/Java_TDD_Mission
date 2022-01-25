package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void create() {
        Player player = new Player("KANG");
        assertThat(player).isEqualTo(new Player("KANG"));
    }

}