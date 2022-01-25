package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Players {

    private final List<Player> players = new ArrayList<>();

    public Players() {
    }

    public Players(List<String> playerNames) {
        for (String name : playerNames) {
            this.players.add(new Player(name));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Players players1 = (Players) o;
        return Objects.equals(players, players1.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(players);
    }

    public List<Player> getPlayers() {
        return this.players;
    }
}
