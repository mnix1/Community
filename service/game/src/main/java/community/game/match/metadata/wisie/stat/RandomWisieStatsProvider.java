package community.game.match.metadata.wisie.stat;

import community.game.match.metadata.wisie.WisieType;

import java.time.Instant;

import static community.game.RandomHelper.randomInteger;

public class RandomWisieStatsProvider implements WisieStatsProvider {
    @Override
    public WisieStats findStats(WisieType type, int level, Instant date) {
        int energyMax = randomInteger(4, 10);
        int healthMax = randomInteger(1, 40);
        return new WisieStats()
                .add(WisieStat.SUMMON_ENERGY_COST, new ConstWisieStatValueProvider(randomInteger(2, 8)))
                .add(WisieStat.ENERGY_MAX, new ConstWisieStatValueProvider(energyMax))
                .add(WisieStat.ENERGY_START, new ConstWisieStatValueProvider(randomInteger(0, energyMax)))
                .add(WisieStat.ENERGY_REGEN, new ConstWisieStatValueProvider(randomInteger(1, 2)))
                .add(WisieStat.HEALTH_MAX, new ConstWisieStatValueProvider(healthMax))
                .add(WisieStat.HEALTH_START, new ConstWisieStatValueProvider(randomInteger(1, healthMax)))
                .add(WisieStat.HEALTH_REGEN, new ConstWisieStatValueProvider(randomInteger(0, 2)))
                .add(WisieStat.ATTACK, new ConstWisieStatValueProvider(randomInteger(2, 10)))
                .add(WisieStat.ATTACK_RANGE, new ConstWisieStatValueProvider(randomInteger(0, 2)))
                .add(WisieStat.ATTACK_ENERGY_COST, new ConstWisieStatValueProvider(randomInteger(0, 3)))
                .add(WisieStat.DEFEND, new ConstWisieStatValueProvider(randomInteger(1, 4)))
                .add(WisieStat.MOVE_RANGE, new ConstWisieStatValueProvider(randomInteger(1, 2)))
                .add(WisieStat.MOVE_ENERGY_COST, new ConstWisieStatValueProvider(randomInteger(0, 2)));
    }
}
