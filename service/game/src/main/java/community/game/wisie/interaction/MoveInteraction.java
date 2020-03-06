package community.game.wisie.interaction;

import community.game.match.Id;
import community.game.match.InteractionType;

public class MoveInteraction extends Interaction {
    public MoveInteraction(Id source, Id target) {
        super(source, target, InteractionType.MOVE);
    }
}
