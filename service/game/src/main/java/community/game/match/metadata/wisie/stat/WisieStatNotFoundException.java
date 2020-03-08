package community.game.match.metadata.wisie.stat;

import community.game.match.metadata.wisie.WisieType;

public class WisieStatNotFoundException extends RuntimeException {
    public WisieStatNotFoundException(WisieStat stat){
        super("WisieStat=" + stat + " not found");
    }
}
