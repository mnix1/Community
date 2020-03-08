package community.game.match.metadata.contestant;

import community.game.Id;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Contestants {
    private final Map<Id, TeamContestants> teamContestants;

    public Contestants(Map<Id, TeamContestants> teamContestants) {
        this.teamContestants = teamContestants;
    }

    public Optional<TeamContestants> getTeam(Id teamId) {
        if (teamContestants.containsKey(teamId)) {
            return Optional.of(teamContestants.get(teamId));
        }
        return Optional.empty();
    }

    public Optional<Contestant> get(Id id) {
        return all().stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public Collection<Contestant> all() {
        return teamContestants.values().stream()
                .map(TeamContestants::all)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
