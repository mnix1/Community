package community.game.match.metadata.wisie.stat;

import community.game.match.metadata.wisie.WisieType;

import java.time.Instant;

public interface WisieStatsProvider {
    WisieStats findStats(WisieType type, int level, Instant date);
}
