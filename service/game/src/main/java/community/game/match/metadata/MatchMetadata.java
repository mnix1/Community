package community.game.match.metadata;

public class MatchMetadata {
    private final Players players;

    public MatchMetadata(Players players) {
        this.players = players;
    }

    public Players getPlayers() {
        return players;
    }
}
