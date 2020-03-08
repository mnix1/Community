package community.game.match.metadata.contestant;

import community.game.Id;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public class TeamContestants {
    private final Id teamId;
    private final Map<Id, Contestant> contestants;

    public TeamContestants(Id teamId, Map<Id, Contestant> contestants) {
        this.teamId = teamId;
        this.contestants = contestants;
    }

    public Optional<Contestant> get(Id id) {
        if (contestants.containsKey(id)) {
            return Optional.of(contestants.get(id));
        }
        return Optional.empty();
    }

    public Collection<Contestant> all() {
        return contestants.values();
    }

    public Id getTeamId() {
        return teamId;
    }
}
