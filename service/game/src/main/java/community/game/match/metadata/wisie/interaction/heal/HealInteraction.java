package community.game.match.metadata.wisie.interaction.heal;

import community.game.match.metadata.wisie.interaction.Interaction;
import community.game.match.metadata.wisie.interaction.InteractionType;

public interface HealInteraction extends Interaction {
    default InteractionType type() {
        return InteractionType.HEAL;
    }
}
