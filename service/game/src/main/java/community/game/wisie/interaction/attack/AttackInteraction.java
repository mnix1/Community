package community.game.wisie.interaction.attack;

import community.game.match.Contestant;
import community.game.match.Id;

import java.util.Map;

public interface AttackInteraction {
    int targetDamage(Contestant source, Map<Id, Contestant> contestants);
}
