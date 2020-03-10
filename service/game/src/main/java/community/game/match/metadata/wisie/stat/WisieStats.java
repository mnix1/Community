package community.game.match.metadata.wisie.stat;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WisieStats {
    private Map<WisieStat, WisieStatValueProvider> stats = new HashMap<>();

    public Optional<WisieStatValueProvider> find(WisieStat stat) {
        return Optional.ofNullable(stats.get(stat));
    }

    public WisieStatValueProvider get(WisieStat stat) {
        return find(stat).orElseThrow(() -> new WisieStatNotFoundException(stat));
    }

    public WisieStats add(WisieStat stat, WisieStatValueProvider provider) {
        stats.put(stat, provider);
        return this;
    }

    public Map<WisieStat, WisieStatValueProvider> getStats() {
        return stats;
    }
}
