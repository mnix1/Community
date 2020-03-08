package community.game.match.metadata.wisie;

import community.game.match.metadata.wisie.interaction.controller.DefaultInteractionController;
import community.game.match.metadata.wisie.interaction.controller.InteractionController;

public enum WisieType {
    BULLO(new DefaultInteractionController(), new DefaultDelay()),//Byku
    LUX_MANE(new DefaultInteractionController(), new DefaultDelay()),//Bujnogrzyw
    TEDDO(new DefaultInteractionController(), new DefaultDelay()),//Dźwiedzior
    ATHLETE(new DefaultInteractionController(), new DefaultDelay()),//Pudziuś
    KIT_O(new DefaultInteractionController(), new DefaultDelay());//Kituś

    private final InteractionController interactionController;
    private final Delay delay;

    WisieType(InteractionController interactionController, Delay delay) {
        this.interactionController = interactionController;
        this.delay = delay;
    }

    public InteractionController getInteractionController() {
        return interactionController;
    }

    public Delay getDelay() {
        return delay;
    }
}
