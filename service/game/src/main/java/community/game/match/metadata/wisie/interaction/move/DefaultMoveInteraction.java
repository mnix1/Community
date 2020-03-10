package community.game.match.metadata.wisie.interaction.move;

import community.game.match.Match;
import community.game.match.metadata.wisie.stat.WisieBaseStats;
import community.game.match.metadata.wisie.stat.WisieStat;
import community.game.match.state.ContestantState;

public class DefaultMoveInteraction implements MoveInteraction {
    @Override
    public void invoke(ContestantState source, Match match) {
        WisieBaseStats baseStats = source.getWisie().getBaseStats();
        source.position(source.getPosition().forward(baseStats.get(WisieStat.MOVE_RANGE).get(source, match)));
        source.energy(source.getEnergy() - baseStats.get(WisieStat.MOVE_ENERGY_COST).get(source, match));
    }
}
