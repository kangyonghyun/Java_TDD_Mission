package bowling.domain.state;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FirstBowlTest {

    @Test
    void create() {
        State firstBowl = new FirstBowl(8);
        assertThat(firstBowl).isEqualTo(new FirstBowl(8));
    }

}