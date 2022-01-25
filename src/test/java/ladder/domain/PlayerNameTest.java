package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerNameTest {

    @Test
    void create() {
        PlayerName name = new PlayerName("KANG");
        assertThat(name).isEqualTo(new PlayerName("KANG"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "KANGIE"})
    @DisplayName("이름이 빈값 및 5자를 초과하면 IllegalArgumentException 반환")
    void invalid_create(String actual) {
        assertThatThrownBy(() -> new PlayerName(actual))
                .isInstanceOf(IllegalArgumentException.class);
    }

}