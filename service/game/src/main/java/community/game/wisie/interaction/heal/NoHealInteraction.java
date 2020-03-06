package community.game.wisie.interaction.heal;

import community.game.match.Contestant;
import community.game.match.Id;
import community.game.wisie.interaction.attack.AttackInteraction;

import java.util.Map;

public class NoHealInteraction implements HealInteraction {
    @Override
    public int targetHeal(Contestant source, Map<Id, Contestant> contestants) {
        return 0;
    }
}
