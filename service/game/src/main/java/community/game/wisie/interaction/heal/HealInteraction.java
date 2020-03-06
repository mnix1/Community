package community.game.wisie.interaction.heal;

import community.game.match.Contestant;
import community.game.match.Id;

import java.util.Map;

public interface HealInteraction {
    int targetHeal(Contestant source, Map<Id, Contestant> contestants);
}
