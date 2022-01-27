package ladder.domain.player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Players {

    public static final String ERROR_NOT_FOUND_PLAYER = "찾는 선수가 없습니다";
    private final List<Player> players = new ArrayList<>();

    public Players() {
    }

    public Players(List<String> playerNames) {
        for (String name : playerNames) {
            this.players.add(new Player(name));
        }
    }

    public int findIndexByName(Player findPlayer) {
        if (!this.players.contains(findPlayer)) {
            throw new IllegalArgumentException(ERROR_NOT_FOUND_PLAYER);
        }

        return this.players.indexOf(findPlayer);
    }

    public List<Player> getPlayers() {
        return this.players;
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

}
