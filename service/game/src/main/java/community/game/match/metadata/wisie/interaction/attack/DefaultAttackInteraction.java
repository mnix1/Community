package community.game.match.metadata.wisie.interaction.attack;

import community.game.match.Match;
import community.game.match.metadata.wisie.stat.WisieStat;
import community.game.match.metadata.wisie.stat.WisieStats;
import community.game.match.state.ContestantState;

public class DefaultAttackInteraction implements AttackInteraction {
    private final ContestantState target;

    public DefaultAttackInteraction(ContestantState target) {
        this.target = target;
    }

    @Override
    public void invoke(ContestantState source, Match match) {
        WisieStats baseStats = source.getWisie().getStats();
        target.health(target.getHealth() - Math.max(baseStats.get(WisieStat.ATTACK).get(source, match) - target.getWisie().getStats().get(WisieStat.DEFEND).get(source, match), 0));
        source.energy(source.getEnergy() - baseStats.get(WisieStat.ATTACK_ENERGY_COST).get(source, match));
    }
}
