package community.game.match;

import community.game.Id;
import community.game.match.metadata.contestant.Contestant;
import community.game.match.metadata.wisie.Wisie;

public class TestContestantBuilder {
    private Id id = Id.random();
    private final Id teamId;
    private Wisie wisie;

    public TestContestantBuilder(Id teamId) {
        this.teamId = teamId;
    }

    TestContestantBuilder wisie(Wisie wisie) {
        this.wisie = wisie;
        return this;
    }

    Contestant build() {
        return new Contestant(id, teamId, wisie);
    }

    public Id getId() {
        return id;
    }

    public Id getTeamId() {
        return teamId;
    }
}
