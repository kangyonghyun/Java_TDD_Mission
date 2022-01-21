package ladder.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LineTest {

    @Test
    void create() {
    }

    @Test
    void move() {
        Line line = LineCreator.createLine(4);

        int move = line.move(0);
        Assertions.assertThat(move).isEqualTo(1);
    }

}