package community.game.match;

import java.util.Map;

public class Match {
    private final Map<Id, Player> players;
    private final Contestants contestants;

    public Match(Map<Id, Player> players, Contestants contestants) {
        this.players = players;
        this.contestants = contestants;
    }
}
