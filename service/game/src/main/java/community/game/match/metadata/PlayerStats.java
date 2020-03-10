package community.game.match.metadata;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PlayerStats {
    private Map<PlayerStat, PlayerStatValueProvider> stats = new HashMap<>();

    public Optional<PlayerStatValueProvider> find(PlayerStat stat) {
        return Optional.ofNullable(stats.get(stat));
    }

    public PlayerStatValueProvider get(PlayerStat stat) {
        return find(stat).orElseThrow(() -> new PlayerStatNotFoundException(stat));
    }

    public PlayerStats add(PlayerStat stat, PlayerStatValueProvider provider) {
        stats.put(stat, provider);
        return this;
    }

    public Map<PlayerStat, PlayerStatValueProvider> getStats() {
        return stats;
    }
}
