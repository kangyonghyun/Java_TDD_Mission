package ladder.domain.player;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {

    @Test
    void create() {
        List<String> names = Arrays.asList("kang", "pobi", "kesun");
        Players players = new Players(names);
        assertThat(players).isEqualTo(new Players(names));
    }

    @ParameterizedTest
    @CsvSource(value = {"kang:0", "pobi:1", "kesun:2"}, delimiter = ':')
    void o_findIndexByName(String name, int expected) {
        List<String> names = Arrays.asList("kang", "pobi", "kesun");
        Players players = new Players(names);
        assertThat(players.findIndexByName(new Player(name))).isEqualTo(expected);
    }

    @Test
    @DisplayName("없는 이름을 찾을 때 IllegalArgumentException 반환")
    void x_findIndexByName() {
        List<String> names = Arrays.asList("kang", "pobi", "kesun");
        Players players = new Players(names);
        assertThatThrownBy(() -> players.findIndexByName(new Player("yong")))
                .isInstanceOf(IllegalArgumentException.class);
    }

}