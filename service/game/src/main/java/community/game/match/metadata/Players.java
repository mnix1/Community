package community.game.match.metadata;

import community.game.Id;

import java.util.Map;

public class Players {
    private final Map<Id, Player> players;

    public Players(Map<Id, Player> players) {
        this.players = players;
    }
}
