package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineCreatorTest {

    @Test
    void create() {
        LineCreator lineCreator = new LineCreator();
        Line line = lineCreator.createLine(4);
        System.out.println(line);
        assertThat(line.getCrosses()).size().isEqualTo(4);
    }

}