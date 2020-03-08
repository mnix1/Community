package community.game.match;

import community.game.Id;
import community.game.match.metadata.Player;
import community.game.match.metadata.wisie.Wisie;
import community.game.match.metadata.wisie.WisieBaseStats;
import community.game.match.metadata.wisie.WisieType;
import org.springframework.stereotype.Service;

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
        return new Wisie(Id.random(), WisieType.random(), randomWisieBaseStats());
    }

    private WisieBaseStats randomWisieBaseStats() {
        int maxHealth = randomInteger(1, 10);
        return new WisieBaseStats(
                randomInteger(2, 8),
                maxHealth,
                randomInteger(1, maxHealth),
                randomInteger(1, 4),
                randomInteger(1, 2),
                randomInteger(1, 3),
                randomInteger(1, 3),
                randomInteger(1, 5),
                randomInteger(1, 5),
                randomInteger(1, 2)
        );
    }

}
