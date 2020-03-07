package community.game.wisie.interaction;

import community.game.contestant.Contestant;

public abstract class ToTargetInteraction extends Interaction {
    protected final Contestant target;

    protected ToTargetInteraction(Contestant source, Contestant target, InteractionType type) {
        super(source, type);
        this.target = target;
    }
}
