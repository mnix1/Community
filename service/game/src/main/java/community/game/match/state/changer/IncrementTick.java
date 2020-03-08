package community.game.match.state.changer;

import community.game.match.Args;
import community.game.match.metadata.MatchMetadata;
import community.game.match.metadata.wisie.stat.WisieStat;
import community.game.match.state.MatchState;

public class IncrementTick implements StateChanger {
    @Override
    public void apply(MatchState state, MatchMetadata metadata) {
        state.tick(state.getTick() + 1);
        state.getContestantStates()
                .forEach(c -> {
                    Args args = new Args(c, state, metadata);
                    int maxEnergy = c.getWisie().getBaseStats().get(WisieStat.ENERGY_MAX).get(args);
                    if (maxEnergy > c.getEnergy()) {
                        c.energy(Math.min(maxEnergy, c.getEnergy() + c.getWisie().getBaseStats().get(WisieStat.ENERGY_REGEN).get(args)));
                    }
                });
    }
}
