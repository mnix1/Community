package community.game.match.state;

import community.game.Id;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MatchState {
    private final Map<Id, ContestantState> contestants = new HashMap<>();
    private final Map<Id, PlayerState> players = new HashMap<>();
    private int tick = 0;

    public Collection<ContestantState> contestantStates() {
        return contestants.values();
    }

    public Optional<ContestantState> contestantState(Id id) {
        if (contestants.containsKey(id)) {
            return Optional.of(contestants.get(id));
        }
        return Optional.empty();
    }

    public MatchState addContestantState(ContestantState contestantState) {
        contestants.put(contestantState.getContestant().getId(), contestantState);
        return this;
    }

    public int getTick() {
        return tick;
    }

    public MatchState tick(int tick) {
        this.tick = tick;
        return this;
    }
}
