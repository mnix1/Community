package community.game.contestant;

import community.game.match.Id;
import community.game.wisie.Wisie;

public class Contestant {
    private final Id id;
    private final Id teamId;
    private final Wisie wisie;
    private final State state;

    public Contestant(Id id, Id teamId, Wisie wisie, State state) {
        this.id = id;
        this.teamId = teamId;
        this.wisie = wisie;
        this.state = state;
    }

    public Id getId() {
        return id;
    }

    public Id getTeamId() {
        return teamId;
    }

    public Wisie getWisie() {
        return wisie;
    }

    public State getState() {
        return state;
    }
}
