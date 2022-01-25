package ladder.domain;

import java.util.Objects;

public class Player {

    private final PlayerName name;

    public Player(String name) {
        this.name = new PlayerName(name);
    }

    public String getPlayerName() {
        return this.name.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Player" + name;
    }

}
