package community.game.match.metadata.wisie;

import community.game.Id;
import community.game.match.metadata.wisie.stat.WisieBaseStats;

public class Wisie {
    private final Id id;
    private final WisieType type;
    private final int level;
    private final WisieBaseStats baseStats;

    public Wisie(Id id, WisieType type, int level, WisieBaseStats baseStats) {
        this.id = id;
        this.type = type;
        this.level = level;
        this.baseStats = baseStats;
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

    public WisieBaseStats getBaseStats() {
        return baseStats;
    }
}
