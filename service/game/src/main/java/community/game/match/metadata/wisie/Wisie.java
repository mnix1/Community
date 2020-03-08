package community.game.match.metadata.wisie;

import community.game.Id;

public class Wisie {
    private final Id id;
    private final WisieType type;
    private final WisieBaseStats baseStats;

    public Wisie(Id id, WisieType type, WisieBaseStats baseStats) {
        this.id = id;
        this.type = type;
        this.baseStats = baseStats;
    }
    public Id getId() {
        return id;
    }
    public WisieType getType() {
        return type;
    }

    public WisieBaseStats getBaseStats() {
        return baseStats;
    }
}
