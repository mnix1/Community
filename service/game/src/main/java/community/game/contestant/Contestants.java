package community.game.contestant;

import community.game.match.Id;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Contestants {
    private final Map<Id, TeamContestants> teamContestants;

    public Contestants(Map<Id, TeamContestants> teamContestants) {
        this.teamContestants = teamContestants;
    }

    public TeamContestants get(Id id) {
        return teamContestants.get(id);
    }

    public List<Contestant> negativeRemainingDelay() {
        return teamContestants.values().stream()
                .map(TeamContestants::getAll)
                .flatMap(Collection::stream)
                .filter(c -> c.getState().getRemainingDelay() < 0)
                .collect(Collectors.toList());
    }
}
