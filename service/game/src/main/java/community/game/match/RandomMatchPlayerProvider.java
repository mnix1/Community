package community.game.match;

import community.game.Id;
import community.game.match.metadata.Player;
import community.game.match.metadata.wisie.Wisie;
import community.game.match.metadata.wisie.stat.RandomWisieStatsProvider;
import community.game.match.metadata.wisie.WisieType;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static community.game.RandomHelper.randomInteger;

@Service
public class RandomMatchPlayerProvider implements MatchPlayerProvider {
    @Override
    public Player get(Id id) {
        int maxEnergy = randomInteger(3, 10);
        return new Player(id, id, true, playerWisies(id), maxEnergy, randomInteger(1, maxEnergy));
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
