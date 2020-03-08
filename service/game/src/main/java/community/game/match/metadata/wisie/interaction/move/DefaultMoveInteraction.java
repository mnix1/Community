package community.game.match.metadata.wisie.interaction.move;

import community.game.match.Args;
import community.game.match.metadata.wisie.stat.WisieBaseStats;
import community.game.match.metadata.wisie.stat.WisieStat;
import community.game.match.state.ContestantState;

public class DefaultMoveInteraction implements MoveInteraction {
    @Override
    public void invoke(Args args) {
        ContestantState source = args.getSource();
        WisieBaseStats baseStats = source.getWisie().getBaseStats();
        source.position(source.getPosition().forward(baseStats.get(WisieStat.MOVE_RANGE).get(args)));
        source.energy(source.getEnergy() - baseStats.get(WisieStat.MOVE_ENERGY_COST).get(args));
    }
}
