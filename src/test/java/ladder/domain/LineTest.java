package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    void create() {
        List<Cross> crosses = new ArrayList<>();
        Cross first = Cross.first(true);
        crosses.add(first);
        crosses.add(first.next(false));

        Line line = new Line(crosses);

        assertThat(line).isEqualTo(new Line(crosses));
    }

    @Test
    void right_move() {
        List<Cross> crosses = new ArrayList<>();
        Cross first = Cross.first(true);
        crosses.add(first);
        crosses.add(first.next(false));
        Line line = new Line(crosses);

        assertThat(line.move(0)).isEqualTo(1);
    }

    @Test
    void stop_move() {
        List<Cross> crosses = new ArrayList<>();
        Cross first = Cross.first(false);
        crosses.add(first);
        crosses.add(first.next(false));
        Line line = new Line(crosses);

        assertThat(line.move(0)).isEqualTo(0);
    }

    @Test
    void left_move() {
        List<Cross> crosses = new ArrayList<>();
        Cross first = Cross.first(true);
        crosses.add(first);
        crosses.add(first.next(false));
        Line line = new Line(crosses);

        assertThat(line.move(1)).isEqualTo(0);
    }

}