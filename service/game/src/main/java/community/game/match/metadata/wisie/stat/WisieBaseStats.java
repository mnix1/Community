package community.game.match.metadata.wisie.stat;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class WisieBaseStats {
    private Map<WisieStat, StatValueProvider> baseStats = new HashMap<>();

    public Optional<StatValueProvider> find(WisieStat stat) {
        return Optional.ofNullable(baseStats.get(stat));
    }

    public StatValueProvider get(WisieStat stat) {
        return find(stat).orElseThrow(() -> new WisieStatNotFoundException(stat));
    }

    public WisieBaseStats add(WisieStat stat, StatValueProvider provider) {
        baseStats.put(stat, provider);
        return this;
    }

    public Map<WisieStat, StatValueProvider> getBaseStats() {
        return baseStats;
    }
}
