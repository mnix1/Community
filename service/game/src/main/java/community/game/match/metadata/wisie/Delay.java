package community.game.match.metadata.wisie;

import community.game.match.metadata.contestant.Contestant;
import community.game.match.metadata.contestant.Contestants;

public interface Delay {
    int delay(Contestant source, Contestants contestants);
}
