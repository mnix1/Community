package community.game.match;

import community.game.wisie.Wisie;

public class Contestant {
    private final Id id;
    private final Id teamId;
    private final Position position;
    private final Wisie wisie;

    public Contestant(Id id, Id teamId, Position position, Wisie wisie) {
        this.id = id;
        this.teamId = teamId;
        this.position = position;
        this.wisie = wisie;
    }

    public Id getId() {
        return id;
    }

    public Id getTeamId() {
        return teamId;
    }

    public Position getPosition() {
        return position;
    }

    public Wisie getWisie() {
        return wisie;
    }
}
