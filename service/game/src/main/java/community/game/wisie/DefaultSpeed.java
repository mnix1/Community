package community.game.wisie;

import community.game.match.Contestant;
import community.game.match.Contestants;

public class DefaultSpeed implements Speed {
    @Override
    public int speed(Contestant source, Contestants contestants) {
        return source.getWisie().getBaseStats().getSpeed();
    }
}
