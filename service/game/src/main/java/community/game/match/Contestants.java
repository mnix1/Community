package community.game.match;

import java.util.Map;

public class Contestants {
    private final Map<Id, TeamContestants> teamContestants;

    public Contestants(Map<Id, TeamContestants> teamContestants) {
        this.teamContestants = teamContestants;
    }


    public TeamContestants get(Id id) {
        return teamContestants.get(id);
    }
}
