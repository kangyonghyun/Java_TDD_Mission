package ladder.domain.generator;

import ladder.domain.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DefaultLineCreatorTest {

    @Test
    void create() {
        LineCreator lineCreator = new DefaultLineCreator();
        Line line = lineCreator.createLine(4);
        assertThat(line.getCrosses()).size().isEqualTo(4);
    }

}