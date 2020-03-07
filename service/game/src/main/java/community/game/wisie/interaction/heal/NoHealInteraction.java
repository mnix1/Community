package community.game.wisie.interaction.heal;

import community.game.contestant.Contestant;
import community.game.contestant.Contestants;
import community.game.wisie.interaction.InteractionType;
import community.game.wisie.interaction.ToTargetInteraction;

public class NoHealInteraction extends ToTargetInteraction implements HealInteraction {
    public NoHealInteraction(Contestant source, Contestant target) {
        super(source, target, InteractionType.HEAL);
    }

    @Override
    public int targetHeal(Contestants contestants) {
        return 0;
    }
}
