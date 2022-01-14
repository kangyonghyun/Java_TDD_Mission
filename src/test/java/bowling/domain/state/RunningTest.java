package bowling.domain.state;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RunningTest {

    @Test
    void isFinal() {
        State firstBowl = new FirstBowl(new Pins(8));
        State ready = new Ready();

        assertThat(firstBowl.isFinal()).isFalse();
        assertThat(ready.isFinal()).isFalse();
    }

}