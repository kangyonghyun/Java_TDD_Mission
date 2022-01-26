package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderResultTest {

    @Test
    void getOne() {
        LadderCreator ladderCreator = new LadderCreator(new LineCreator());
        Ladder ladder = ladderCreator.createLadder(5, 4);

        LadderResult result = ladder.play();
//        int oneResult = result.getOneResult(0);
        System.out.println(result.getResult());
//        Assertions.assertThat(oneResult).isEqualTo(?);
    }

    @Test
    void getAll() {
        LadderCreator ladderCreator = new LadderCreator(new LineCreator());
        Ladder ladder = ladderCreator.createLadder(5, 4);
        LadderResult result = ladder.play();

        List<Integer> allResult = result.getAllResult();
        assertThat(allResult).size().isEqualTo(4);
    }

}