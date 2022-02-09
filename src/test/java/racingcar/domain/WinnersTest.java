package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    void addWinner() {
        Winners winners = new Winners();
        winners.addWinner(new Car("k5", 5));
        assertThat(winners.getWinners()).containsExactly(new Car("k5", 5));
    }

}