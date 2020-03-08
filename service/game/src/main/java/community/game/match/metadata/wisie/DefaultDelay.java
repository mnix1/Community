package community.game.match.metadata.wisie;

import community.game.match.metadata.contestant.Contestant;
import community.game.match.metadata.contestant.Contestants;

public class DefaultDelay implements Delay {
    @Override
    public int delay(Contestant source, Contestants contestants) {
        return source.getWisie().getBaseStats().getDelay();
    }
}
