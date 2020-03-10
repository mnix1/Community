package community.game.match.metadata.wisie;

import community.game.Id;
import community.game.match.metadata.wisie.stat.WisieStats;

public class Wisie {
    private final Id id;
    private final WisieType type;
    private final int level;
    private final WisieStats stats;

    public Wisie(Id id, WisieType type, int level, WisieStats stats) {
        this.id = id;
        this.type = type;
        this.level = level;
        this.stats = stats;
    }

    public Id getId() {
        return id;
    }

    public WisieType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public WisieStats getStats() {
        return stats;
    }
}
