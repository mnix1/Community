package community.game.match.metadata.wisie.interaction.attack;

import community.game.match.metadata.wisie.interaction.Interaction;
import community.game.match.metadata.wisie.interaction.InteractionType;

public interface AttackInteraction extends Interaction {
    default InteractionType type() {
        return InteractionType.ATTACK;
    }
}
