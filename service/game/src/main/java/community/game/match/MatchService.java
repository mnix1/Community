package community.game.match;

import community.game.Id;
import community.game.match.metadata.MatchMetadata;
import community.game.match.metadata.Players;
import community.game.match.state.MatchState;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MatchService implements MatchCreator {
    private final Map<Id, Match> matches = new ConcurrentHashMap<>();
    private final MatchPlayerProvider playerProvider;

    public MatchService(MatchPlayerProvider playerProvider) {
        this.playerProvider = playerProvider;
    }

    @Override
    public Match create(Id main, Id opponent) {
        Players players = new Players(playerProvider.get(main, true), playerProvider.get(opponent, false));
        MatchMetadata metadata = new MatchMetadata(players, new Board());
        Match match = new Match(Id.random(), metadata);
        matches.put(match.getId(), match);
        return match;
    }

    public Optional<Match> getMatch(Id id) {
        return Optional.ofNullable(matches.get(id));
    }
}
