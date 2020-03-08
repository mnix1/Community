package community.game.match.metadata;

import java.time.Instant;

public class MatchMetadata {
    private final Instant startInstant = Instant.now();
    private final Players players;

    public MatchMetadata(Players players) {
        this.players = players;
    }

    public Players getPlayers() {
        return players;
    }

    public Instant getStartInstant() {
        return startInstant;
    }
}
