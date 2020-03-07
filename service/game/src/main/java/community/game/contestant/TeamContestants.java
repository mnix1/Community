package community.game.contestant;

import community.game.match.Id;

import java.util.Collection;
import java.util.Map;

public class TeamContestants {
    private Map<Id, Contestant> contestants;

    public TeamContestants(Map<Id, Contestant> contestants) {
        this.contestants = contestants;
    }

    public Contestant get(Id id) {
        return contestants.get(id);
    }

    public Collection<Contestant> getAll() {
        return contestants.values();
    }
}
