package community.game.match.metadata;

import community.game.match.Board;

import java.time.Instant;

public class MatchMetadata {
    private final Instant created = Instant.now();
    private final Players players;
    private final Board board;

    public MatchMetadata(Players players, Board board) {
        this.players = players;
        this.board = board;
    }

    public Instant getCreated() {
        return created;
    }

    public Players getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }
}
