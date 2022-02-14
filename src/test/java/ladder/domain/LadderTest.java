package ladder.domain;

import ladder.domain.generator.DefaultLadderCreator;
import ladder.domain.generator.DefaultLineCreator;
import ladder.domain.generator.LadderCreator;
import ladder.domain.result.LadderResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    @Test
    void create() {
        List<Cross> crosses1 = new ArrayList<>();
        Cross first = Cross.first(true);
        crosses1.add(first);
        crosses1.add(first.next(false));
        Line line1 = new Line(crosses1);

        List<Line> lines = new ArrayList<>();
        lines.add(line1);

        Ladder ladder = new Ladder(2, lines);
        assertThat(ladder).isEqualTo(new Ladder(2, lines));
    }

    @Test
    void manual_play() {
        List<Cross> crosses1 = new ArrayList<>();
        Cross first = Cross.first(true);
        Cross middle = first.next(false);
        Cross last = middle.last();
        crosses1.add(first);
        crosses1.add(middle);
        crosses1.add(last);
        Line line1 = new Line(crosses1);

        List<Cross> crosses2 = new ArrayList<>();
        Cross first2 = Cross.first(false);
        Cross middle2 = first2.next(true);
        Cross last2 = middle2.last();
        crosses2.add(first2);
        crosses2.add(middle2);
        crosses2.add(last2);
        Line line2 = new Line(crosses2);

        List<Cross> crosses3 = new ArrayList<>();
        Cross first3 = Cross.first(true);
        Cross middle3 = first3.next(false);
        Cross last3 = middle3.last();
        crosses3.add(first3);
        crosses3.add(middle3);
        crosses3.add(last3);
        Line line3 = new Line(crosses3);

        List<Line> lines = new ArrayList<>();
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);

        Ladder ladder = new Ladder(3, lines);
        LadderResult result = ladder.play();

        assertThat(result.getResult()).size().isEqualTo(3);
        assertThat(result.getOneResult(0)).isEqualTo(2);
        assertThat(result.getOneResult(1)).isEqualTo(1);
        assertThat(result.getOneResult(2)).isEqualTo(0);
    }

    @Test
    @DisplayName("width 만큼 결과값이 Map 에 저장")
    void random_play() {
        LadderCreator ladderCreator = new DefaultLadderCreator(new DefaultLineCreator());
        Ladder ladder = ladderCreator.createLadder(4, 5);

        LadderResult result = ladder.play();

        assertThat(result.getResult().size()).isEqualTo(4);
    }

}
