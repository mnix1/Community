package community.game.match.state;

import community.game.Id;
import community.game.NotFoundException;
import community.game.match.Match;
import community.game.match.metadata.Player;
import community.game.match.metadata.PlayerStat;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MatchState {
    private final Map<Id, ContestantState> contestants = new HashMap<>();
    private final Map<Id, PlayerState> players;
    private int tick = 0;

    public MatchState(Match match) {
        this.players = match.getMetadata().getPlayers().all().stream().collect(
                Collectors.toMap(
                        Player::getId,
                        p -> new PlayerState(p)
                                .energy(p.getStats().get(PlayerStat.ENERGY_START).get(null, match))
                                .health(p.getStats().get(PlayerStat.HEALTH_START).get(null, match))
                )
        );
    }

    public Optional<ContestantState> findContestant(Id id) {
        return Optional.ofNullable(contestants.get(id));
    }

    public ContestantState getContestant(Id id) {
        return findContestant(id).orElseThrow(() -> new NotFoundException("getContestantState Id=" + id));
    }

    public Optional<PlayerState> findPlayer(Id id) {
        return Optional.ofNullable(players.get(id));
    }

    public PlayerState getPlayer(Id id) {
        return findPlayer(id).orElseThrow(() -> new NotFoundException("getPlayer Id=" + id));
    }

    public Collection<ContestantState> allContestants() {
        return contestants.values();
    }

    public Collection<PlayerState> allPlayers() {
        return players.values();
    }

    public MatchState addContestant(ContestantState contestantState) {
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
