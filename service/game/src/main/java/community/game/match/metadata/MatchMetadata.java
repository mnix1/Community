package community.game.match.metadata;

import community.game.match.metadata.contestant.Contestants;

public class MatchMetadata {
    private final Players players;
    private final Contestants contestants;

    public MatchMetadata(Players players, Contestants contestants) {
        this.players = players;
        this.contestants = contestants;
    }

    public Players getPlayers() {
        return players;
    }

    public Contestants getContestants() {
        return contestants;
    }
}
