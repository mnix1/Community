package community.game.wisie.interaction.move;

import community.game.match.Contestant;
import community.game.match.Id;
import community.game.match.Position;

import java.util.Map;

public interface MoveInteraction {
    Position targetPosition(Contestant source, Map<Id, Contestant> contestants);
}
