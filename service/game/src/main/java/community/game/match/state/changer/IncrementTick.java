package community.game.match.state.changer;

import community.game.match.Match;
import community.game.match.metadata.PlayerStat;
import community.game.match.metadata.wisie.stat.WisieStat;
import community.game.match.state.MatchState;

public class IncrementTick implements StateChanger {
    @Override
    public void apply(Match match) {
        MatchState state = match.getState();
        state.tick(state.getTick() + 1);
        regenContestantsEnergyAndHealth(match);
        regenPlayersEnergyAndHealth(match);
    }

    private void regenContestantsEnergyAndHealth(Match match) {
        match.getState().allContestants()
                .forEach(c -> {
                    int maxEnergy = c.getWisie().getStats().get(WisieStat.ENERGY_MAX).get(c, match);
                    if (maxEnergy > c.getEnergy()) {
                        c.energy(Math.min(maxEnergy, c.getEnergy() + c.getWisie().getStats().get(WisieStat.ENERGY_REGEN).get(c, match)));
                    }
                    int maxHealth = c.getWisie().getStats().get(WisieStat.HEALTH_MAX).get(c, match);
                    if (maxHealth > c.getHealth()) {
                        c.health(Math.min(maxHealth, c.getHealth() + c.getWisie().getStats().get(WisieStat.HEALTH_REGEN).get(c, match)));
                    }
                });
    }

    private void regenPlayersEnergyAndHealth(Match match) {
        match.getState().allPlayers()
                .forEach(p -> {
                    int maxEnergy = p.getPlayer().getStats().get(PlayerStat.ENERGY_MAX).get(p, match);
                    if (maxEnergy > p.getEnergy()) {
                        p.energy(Math.min(maxEnergy, p.getEnergy() + p.getPlayer().getStats().get(PlayerStat.ENERGY_REGEN).get(p, match)));
                    }
                    int maxHealth = p.getPlayer().getStats().get(PlayerStat.HEALTH_MAX).get(p, match);
                    if (maxHealth > p.getHealth()) {
                        p.health(Math.min(maxHealth, p.getHealth() + p.getPlayer().getStats().get(PlayerStat.HEALTH_REGEN).get(p, match)));
                    }
                });
    }
}
