package community.game.match.metadata.contestant;

import community.game.Id;
import community.game.match.metadata.wisie.Wisie;

public class Contestant {
    private final Id id;
    private final Id playerId;
    private final Wisie wisie;

    public Contestant(Id id, Id playerId, Wisie wisie) {
        this.id = id;
        this.playerId = playerId;
        this.wisie = wisie;
    }

    public Id getId() {
        return id;
    }

    public Id getPlayerId() {
        return playerId;
    }

    public Wisie getWisie() {
        return wisie;
    }
}
