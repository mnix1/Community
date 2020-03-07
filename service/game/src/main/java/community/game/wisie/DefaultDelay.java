package community.game.wisie;

import community.game.contestant.Contestant;
import community.game.contestant.Contestants;

public class DefaultDelay implements Delay {
    @Override
    public int delay(Contestant source, Contestants contestants) {
        return source.getWisie().getBaseStats().getDelay();
    }
}
