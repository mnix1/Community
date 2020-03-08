package community.game.match.metadata.wisie.stat;

import community.game.match.metadata.wisie.WisieType;

import java.time.Instant;

import static community.game.RandomHelper.randomInteger;

public class RandomWisieStatsProvider implements WisieStatsProvider {
    @Override
    public WisieBaseStats findStats(WisieType type, int level, Instant date) {
        int energyMax = randomInteger(4, 10);
        int healthMax = randomInteger(1, 40);
        return new WisieBaseStats()
                .add(WisieStat.PLAY_COST, new ConstStatValueProvider(randomInteger(2, 8)))
                .add(WisieStat.ENERGY_MAX, new ConstStatValueProvider(energyMax))
                .add(WisieStat.ENERGY_START, new ConstStatValueProvider(randomInteger(0, energyMax)))
                .add(WisieStat.ENERGY_REGEN, new ConstStatValueProvider(randomInteger(1, 2)))
                .add(WisieStat.HEALTH_MAX, new ConstStatValueProvider(healthMax))
                .add(WisieStat.HEALTH_START, new ConstStatValueProvider(randomInteger(1, healthMax)))
                .add(WisieStat.HEALTH_REGEN, new ConstStatValueProvider(randomInteger(0, 2)))
                .add(WisieStat.ATTACK, new ConstStatValueProvider(randomInteger(2, 10)))
                .add(WisieStat.ATTACK_RANGE, new ConstStatValueProvider(randomInteger(0, 2)))
                .add(WisieStat.ATTACK_ENERGY_COST, new ConstStatValueProvider(randomInteger(0, 3)))
                .add(WisieStat.DEFEND, new ConstStatValueProvider(randomInteger(1, 4)))
                .add(WisieStat.MOVE_RANGE, new ConstStatValueProvider(randomInteger(1, 2)))
                .add(WisieStat.MOVE_ENERGY_COST, new ConstStatValueProvider(randomInteger(0, 2)));
    }
}
