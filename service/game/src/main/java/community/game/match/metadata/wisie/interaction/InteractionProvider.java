package community.game.match.metadata.wisie.interaction;

import community.game.match.metadata.wisie.WisieType;
import community.game.match.metadata.wisie.interaction.controller.DefaultInteractionController;
import community.game.match.metadata.wisie.interaction.controller.InteractionController;

import java.time.Instant;

public interface InteractionProvider {
    static InteractionController findController(WisieType type, Instant date){
        return new DefaultInteractionController();
    }
}
