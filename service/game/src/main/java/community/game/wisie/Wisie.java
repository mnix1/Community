package community.game.wisie;

public class Wisie {
    private final WisieType type;
    private final WisieBaseStats baseStats;

    public Wisie(WisieType type, WisieBaseStats baseStats) {
        this.type = type;
        this.baseStats = baseStats;
    }

    public WisieType getType() {
        return type;
    }

    public WisieBaseStats getBaseStats() {
        return baseStats;
    }
}
