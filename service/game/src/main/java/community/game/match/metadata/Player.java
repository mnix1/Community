package community.game.match.metadata;

import community.game.Id;

public class Player {
    private final Id id;
    private final Id teamId;
    private final boolean main;

    public Player(Id id, Id teamId, boolean main) {
        this.id = id;
        this.teamId = teamId;
        this.main = main;
    }

    public Id getId() {
        return id;
    }

    public Id getTeamId() {
        return teamId;
    }

    public boolean isMain() {
        return main;
    }
}
