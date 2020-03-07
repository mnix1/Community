package community.game.wisie.interaction.move;

import community.game.contestant.Contestant;
import community.game.match.*;
import community.game.wisie.interaction.Interaction;
import community.game.wisie.interaction.InteractionType;

public class DefaultMoveInteraction extends Interaction implements MoveInteraction {
    public DefaultMoveInteraction(Contestant source) {
        super(source, InteractionType.MOVE);
    }

    @Override
    public Position targetPosition() {
        return source.getState().getPosition().forward(source.getWisie().getBaseStats().getMoveRange());
    }
}
