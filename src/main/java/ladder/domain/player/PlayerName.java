package ladder.domain.player;

import java.util.Objects;

public class PlayerName {

    public static final String ERROR_RANGE_OF_NAME_MSG = "이름은 최소 1 ~ 5자를 입력해주세요.";
    private final String name;

    public PlayerName(String name) {
        if (name.length() > 5 || name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_RANGE_OF_NAME_MSG);
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayerName that = (PlayerName) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "PlayerName= " + name;
    }

}
