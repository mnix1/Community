package community.game.match.metadata.wisie.stat;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WisieStats {
    private Map<WisieStat, StatValueProvider> stats = new HashMap<>();

    public Optional<StatValueProvider> find(WisieStat stat) {
        return Optional.ofNullable(stats.get(stat));
    }

    public StatValueProvider get(WisieStat stat) {
        return find(stat).orElseThrow(() -> new WisieStatNotFoundException(stat));
    }

    public WisieStats add(WisieStat stat, StatValueProvider provider) {
        stats.put(stat, provider);
        return this;
    }

    public Map<WisieStat, StatValueProvider> getStats() {
        return stats;
    }
}
