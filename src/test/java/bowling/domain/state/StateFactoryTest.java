package bowling.domain.state;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StateFactoryTest {

    @Test
    void ready() {
        assertThat(StateFactory.ready()).isEqualTo(StateFactory.ready());
        assertThat(StateFactory.ready()).isSameAs(StateFactory.ready());
    }

    @Test
    void firstBowl() {
        State ready = StateFactory.ready();

        assertThat(StateFactory.firstBowl(5)).isEqualTo(ready.bowl(5));
    }

}