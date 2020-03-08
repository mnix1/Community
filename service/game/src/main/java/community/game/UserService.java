package community.game;

import community.game.match.metadata.wisie.Wisie;
import community.game.match.metadata.wisie.WisieBaseStats;
import community.game.match.metadata.wisie.WisieType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static community.game.RandomHelper.randomInteger;

@Service
public class UserService {
    public List<Wisie> userWisies(Id id) {
        return IntStream.range(0, 8).boxed().map(i -> randomWisie()).collect(Collectors.toList());
    }

    private Wisie randomWisie() {
        return new Wisie(WisieType.random(), randomWisieBaseStats());
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
