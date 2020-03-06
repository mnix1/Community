package community.game.wisie;

import community.game.wisie.interaction.controller.DefaultInteractionController;
import community.game.wisie.interaction.controller.InteractionController;

public enum WisieType {
    BULLO(new DefaultInteractionController(), new DefaultSpeed()),//Byku
    LUX_MANE(new DefaultInteractionController(), new DefaultSpeed()),//Bujnogrzyw
    TEDDO(new DefaultInteractionController(), new DefaultSpeed()),//Dźwiedzior
    ATHLETE(new DefaultInteractionController(), new DefaultSpeed()),//Pudziuś
    KIT_O(new DefaultInteractionController(), new DefaultSpeed());//Kituś

    private final InteractionController interactionController;
    private final Speed speed;

    WisieType(InteractionController interactionController, Speed speed) {
        this.interactionController = interactionController;
        this.speed = speed;
    }

    public InteractionController getInteractionController() {
        return interactionController;
    }

    public Speed getSpeed() {
        return speed;
    }
}
