package community.game.match;

import community.game.Id;
import community.game.match.metadata.Player;

public interface MatchPlayerProvider {
    Player get(Id id, boolean main);
}
