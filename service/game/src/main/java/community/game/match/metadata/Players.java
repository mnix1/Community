package community.game.match.metadata;

import community.game.Id;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Players {
    private final Map<Id, Player> players;

    public Players(Player... players) {
        this.players = Arrays.stream(players).collect(Collectors.toMap(Player::getId, p -> p));
    }

    public Collection<Player> all() {
        return players.values();
    }

    public Optional<Player> find(Id id) {
        return Optional.ofNullable(players.get(id));
    }
}
