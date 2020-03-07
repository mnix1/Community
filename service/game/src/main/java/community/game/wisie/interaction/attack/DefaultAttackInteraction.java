package community.game.wisie.interaction.attack;

import community.game.contestant.Contestant;
import community.game.contestant.Contestants;
import community.game.wisie.interaction.InteractionType;
import community.game.wisie.interaction.ToTargetInteraction;

public class DefaultAttackInteraction extends ToTargetInteraction implements AttackInteraction {
    public DefaultAttackInteraction(Contestant source, Contestant target) {
        super(source, target, InteractionType.ATTACK);
    }

    @Override
    public int targetDamage(Contestants contestants) {
        return source.getWisie().getBaseStats().getAttack();
    }
}
