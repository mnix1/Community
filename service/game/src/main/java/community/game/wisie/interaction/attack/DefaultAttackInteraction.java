package community.game.wisie.interaction.attack;

import community.game.match.Contestant;
import community.game.match.Id;

import java.util.Map;

public class DefaultAttackInteraction implements AttackInteraction {
    @Override
    public int targetDamage(Contestant source, Map<Id, Contestant> contestants) {
        return source.getWisie().getBaseStats().getAttack();
    }
}
