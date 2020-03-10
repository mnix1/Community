package community.game.match;

import community.game.match.metadata.Player;
import community.game.match.play.SummonWisiePlay;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static community.game.RandomHelper.randomElement;
import static community.game.RandomHelper.randomInteger;
import static java.time.Instant.now;

class MatchExporterTest {
    @Test
    void export() {
        Match match = new TestMatchBuilder().build();
        Collection<Player> players = match.getMetadata().getPlayers().all();
        for (int i = 0; i < 10; i++) {
            Player player = randomElement(players);
            match.play(new SummonWisiePlay(player.getId(), randomElement(player.allWisies()).getId(), now().minusSeconds(100).plusSeconds(i)));
            for (int j = 0; j < randomInteger(1, 3); j++) {
                match.nextTick();
            }
        }

        String export = new MatchExporter(match).export();

        System.out.println(export);
    }

}