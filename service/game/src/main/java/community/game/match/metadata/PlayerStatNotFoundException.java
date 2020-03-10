package community.game.match.metadata;

import community.game.match.metadata.wisie.stat.WisieStat;

public class PlayerStatNotFoundException extends RuntimeException {
    public PlayerStatNotFoundException(PlayerStat stat){
        super("PlayerStat=" + stat + " not found");
    }
}
