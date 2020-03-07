package community.game.wisie.interaction;

import community.game.contestant.Contestant;

public abstract class Interaction {
    protected final Contestant source;
    protected final InteractionType type;

    protected Interaction(Contestant source, InteractionType type) {
        this.source = source;
        this.type = type;
    }
}
