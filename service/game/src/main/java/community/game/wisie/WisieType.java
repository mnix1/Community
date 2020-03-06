package community.game.wisie;

import community.game.wisie.interaction.attack.AttackInteraction;
import community.game.wisie.interaction.attack.DefaultAttackInteraction;
import community.game.wisie.interaction.heal.HealInteraction;
import community.game.wisie.interaction.controller.InteractionController;
import community.game.wisie.interaction.heal.NoHealInteraction;
import community.game.wisie.interaction.move.DefaultMoveInteraction;
import community.game.wisie.interaction.move.MoveInteraction;

public enum WisieType {
    BULLO(interactionController, new DefaultMoveInteraction(), new DefaultAttackInteraction(), new NoHealInteraction()),//Byku
    LUX_MANE(interactionController, new DefaultMoveInteraction(), new DefaultAttackInteraction(), new NoHealInteraction()),//Bujnogrzyw
    TEDDO(interactionController, new DefaultMoveInteraction(), new DefaultAttackInteraction(), new NoHealInteraction()),//Dźwiedzior
    ATHLETE(interactionController, new DefaultMoveInteraction(), new DefaultAttackInteraction(), new NoHealInteraction()),//Pudziuś
    KIT_O(interactionController, new DefaultMoveInteraction(), new DefaultAttackInteraction(), new NoHealInteraction());//Kituś
    private final InteractionController interactionController;
    private final MoveInteraction moveInteraction;
    private final AttackInteraction attackInteraction;
    private final HealInteraction healInteraction;

    WisieType(InteractionController interactionController, MoveInteraction moveInteraction, AttackInteraction attackInteraction, HealInteraction healInteraction) {
        this.interactionController = interactionController;
        this.moveInteraction = moveInteraction;
        this.attackInteraction = attackInteraction;
        this.healInteraction = healInteraction;
    }

    public InteractionController getInteractionController() {
        return interactionController;
    }

    public MoveInteraction getMoveInteraction() {
        return moveInteraction;
    }

    public AttackInteraction getAttackInteraction() {
        return attackInteraction;
    }

    public HealInteraction getHealInteraction() {
        return healInteraction;
    }
}
