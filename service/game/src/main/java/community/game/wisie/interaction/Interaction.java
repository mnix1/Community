package community.game.wisie.interaction;

import community.game.match.Id;
import community.game.match.InteractionType;

public abstract class Interaction {
    private final Id source;
    private final Id target;
    private final InteractionType type;

    protected Interaction(Id source, Id target, InteractionType type) {
        this.source = source;
        this.target = target;
        this.type = type;
    }
}
