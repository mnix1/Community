package community.game.match;

import community.game.Id;
import community.game.match.metadata.ConstPlayerStatValueProvider;
import community.game.match.metadata.Player;
import community.game.match.metadata.PlayerStat;
import community.game.match.metadata.PlayerStats;
import community.game.match.metadata.wisie.Wisie;
import community.game.match.metadata.wisie.WisieType;
import community.game.match.metadata.wisie.stat.RandomWisieStatsProvider;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static community.game.RandomHelper.randomInteger;

@Service
public class RandomMatchPlayerProvider implements MatchPlayerProvider {
    @Override
    public Player get(Id id, boolean main) {
        int maxEnergy = randomInteger(3, 10);
        int maxHealth = randomInteger(3, 20);
        PlayerStats stats = new PlayerStats()
                .add(PlayerStat.ENERGY_MAX, new ConstPlayerStatValueProvider(maxEnergy))
                .add(PlayerStat.ENERGY_START, new ConstPlayerStatValueProvider(randomInteger(1, maxEnergy)))
                .add(PlayerStat.ENERGY_REGEN, new ConstPlayerStatValueProvider(randomInteger(1, 2)))
                .add(PlayerStat.HEALTH_MAX, new ConstPlayerStatValueProvider(maxHealth))
                .add(PlayerStat.HEALTH_START, new ConstPlayerStatValueProvider(randomInteger(1, maxHealth)))
                .add(PlayerStat.HEALTH_REGEN, new ConstPlayerStatValueProvider(randomInteger(1, 3)));
        return new Player(id, id, main, playerWisies(id), stats);
    }

    private List<Wisie> playerWisies(Id id) {
        return IntStream.range(0, 8).boxed().map(i -> randomWisie()).collect(Collectors.toList());
    }

    private Wisie randomWisie() {
        WisieType type = WisieType.random();
        int level = randomInteger(1, 10);
        return new Wisie(Id.random(), type, level, new RandomWisieStatsProvider().findStats(type, level, Instant.now()));
    }
}
