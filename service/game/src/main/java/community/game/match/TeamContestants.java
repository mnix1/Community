package community.game.match;

import java.util.Collection;
import java.util.List;
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
