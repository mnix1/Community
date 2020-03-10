package community.game.match;

import com.google.gson.Gson;
import community.game.match.metadata.MatchMetadata;
import community.game.match.metadata.Player;
import community.game.match.metadata.wisie.Wisie;
import community.game.match.metadata.wisie.stat.StatValueProvider;
import community.game.match.metadata.wisie.stat.WisieStat;
import community.game.match.state.ContestantState;
import community.game.match.state.MatchState;
import community.game.match.state.PlayerState;
import community.game.match.state.changer.StateChanger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchExporter {
    private final Match match;
    private final List<List<StateChanger>> allStateChangers;

    public MatchExporter(Match match) {
        this.match = new Match(match.getId(), new MatchState(match.getMetadata()), match.getMetadata());
        this.allStateChangers = match.getAllStateChangers();
    }

    public String export() {
        return new Gson().toJson(Map.of("id", match.getId().toString(), "metadata", metadata(match.getMetadata()), "state", state()));
    }

    private List<Map<String, Object>> state() {
        List<Map<String, Object>> ticks = new ArrayList<>();
        ticks.add(tick());
        allStateChangers.forEach(stateChangers -> {
            match.execute(stateChangers);
            ticks.add(tick());
        });
        return ticks;
    }

    private Map<String, Object> tick() {
        return Map.of("tick", match.getState().getTick(), "players", playerStates(match.getState().allPlayers()), "contestants", contestantStates(match.getState().allContestants()));
    }

    private List<Map<String, ?>> playerStates(Collection<PlayerState> playerStates) {
        return playerStates.stream().map(p -> Map.of("id", p.getId().toString(), "energy", p.getEnergy())).collect(Collectors.toList());
    }

    private List<Map<String, ?>> contestantStates(Collection<ContestantState> contestantStates) {
        return contestantStates.stream().map(c -> Map.of("id", c.getId().toString(), "position", c.getPosition(), "energy", c.getEnergy(), "health", c.getHealth(), "playerId", c.getPlayer().getId().toString(), "wisieId", c.getWisie().getId().toString())).collect(Collectors.toList());
    }

    private Map<String, Object> metadata(MatchMetadata metadata) {
        return Map.of("start", metadata.getStart(), "board", board(metadata.getBoard()), "players", players(metadata.getPlayers().all()));
    }

    private List<Map<String, Object>> players(Collection<Player> players) {
        return players.stream().map(p -> Map.of("id", p.getId().toString(), "teamId", p.getTeamId(), "main", p.isMain(), "maxEnergy", p.getMaxEnergy(), "startEnergy", p.getStartEnergy(), "wisies", wisies(p.allWisies()))).collect(Collectors.toList());
    }

    private List<Map<String, Object>> wisies(Collection<Wisie> wisies) {
        return wisies.stream().map(w -> Map.of("id", w.getId().toString(), "type", w.getType(), "level", w.getLevel(), "baseStats", baseStats(w.getBaseStats().getBaseStats()))).collect(Collectors.toList());
    }

    private Map<Object, Object> baseStats(Map<WisieStat, StatValueProvider> baseStats) {
        return baseStats.keySet().stream().collect(Collectors.toMap(w -> w, w -> {
            StatValueProvider provider = baseStats.get(w);
            return Map.of("type", provider.getType(), "provider", provider);
        }));
    }

    private Map<String, Object> board(Board board) {
        return Map.of("minRow", board.getMinRow(), "maxRow", board.getMaxRow(), "minColumn", board.getMinColumn(), "maxColumn", board.getMaxColumn());
    }
}
