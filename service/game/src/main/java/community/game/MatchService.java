package community.game;

import community.game.match.Match;
import community.game.match.metadata.MatchMetadata;
import community.game.match.metadata.Player;
import community.game.match.metadata.Players;
import community.game.match.metadata.contestant.Contestant;
import community.game.match.metadata.contestant.Contestants;
import community.game.match.state.MatchState;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MatchService {
    private Map<Id, Match> matches = new ConcurrentHashMap<>();
    private UserService userService;

    public Match createMatch(Id main, Id opponent) {
        Player mainPlayer = new Player(main, main, true);
        Player opponentPlayer = new Player(opponent, opponent, false);
        MatchMetadata metadata = new MatchMetadata(new Players(mainPlayer, opponentPlayer), new Contestants());
        Match match = new Match(Id.random(), new MatchState(), metadata);
        matches.put(match.getId(), match);
        return match;
    }

    public Optional<Match> get(Id id) {
        if (matches.containsKey(id)) {
            return Optional.of(matches.get(id));
        }
        return Optional.empty();
    }
}
