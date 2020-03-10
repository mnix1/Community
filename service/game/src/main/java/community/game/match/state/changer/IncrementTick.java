package community.game.match.state.changer;

import community.game.match.Match;
import community.game.match.metadata.wisie.stat.WisieStat;
import community.game.match.state.MatchState;

public class IncrementTick implements StateChanger {
    @Override
    public void apply(Match match) {
        MatchState state = match.getState();
        state.tick(state.getTick() + 1);
        regenEnergyAndHealth(match);
    }

    private void regenEnergyAndHealth(Match match) {
        match.getState().allContestants()
                .forEach(c -> {
                    int maxEnergy = c.getWisie().getBaseStats().get(WisieStat.ENERGY_MAX).get(c, match);
                    if (maxEnergy > c.getEnergy()) {
                        c.energy(Math.min(maxEnergy, c.getEnergy() + c.getWisie().getBaseStats().get(WisieStat.ENERGY_REGEN).get(c, match)));
                    }
                    int maxHealth = c.getWisie().getBaseStats().get(WisieStat.HEALTH_MAX).get(c, match);
                    if (maxHealth > c.getHealth()) {
                        c.health(Math.min(maxHealth, c.getHealth() + c.getWisie().getBaseStats().get(WisieStat.HEALTH_REGEN).get(c, match)));
                    }
                });
    }
}
