package community.game.match.state;

import community.game.Id;
import community.game.match.metadata.MatchMetadata;
import community.game.match.metadata.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MatchState {
    private final Map<Id, ContestantState> contestants = new HashMap<>();
    private final Map<Id, PlayerState> players;
    private int tick = 0;

    public MatchState(MatchMetadata metadata) {
        this.players = metadata.getPlayers().all().stream().collect(Collectors.toMap(Player::getId, PlayerState::new));
    }

    public Collection<ContestantState> getContestantStates() {
        return contestants.values();
    }

    public Optional<ContestantState> findContestantState(Id id) {
        return Optional.ofNullable(contestants.get(id));
    }

    public MatchState addContestantState(ContestantState contestantState) {
        contestants.put(contestantState.getId(), contestantState);
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
