package community.game.wisie.interaction.move;

import community.game.match.Contestant;
import community.game.match.Id;
import community.game.match.Position;
import community.game.wisie.interaction.attack.AttackInteraction;

import java.util.Map;

public class DefaultMoveInteraction implements MoveInteraction {
    @Override
    public Position targetPosition(Contestant source, Map<Id, Contestant> contestants) {
        return source.getPosition().forward(source.getWisie().getBaseStats().getMoveRange());
    }
}
