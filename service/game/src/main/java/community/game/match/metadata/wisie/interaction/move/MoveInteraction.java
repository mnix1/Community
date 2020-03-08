package community.game.match.metadata.wisie.interaction.move;

import community.game.match.metadata.wisie.interaction.Interaction;
import community.game.match.metadata.wisie.interaction.InteractionType;

public interface MoveInteraction extends Interaction {
    default InteractionType type() {
        return InteractionType.MOVE;
    }
}
