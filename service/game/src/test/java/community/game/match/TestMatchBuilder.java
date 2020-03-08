package community.game.match;

import community.game.Id;
import community.game.RandomHelper;
import community.game.match.metadata.MatchMetadata;
import community.game.match.metadata.Player;
import community.game.match.metadata.Players;
import community.game.match.state.ContestantState;
import community.game.match.state.MatchState;
import community.game.match.state.Position;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestMatchBuilder {
    private Player main = new RandomMatchPlayerProvider().get(Id.random());
    private Player opponent = new RandomMatchPlayerProvider().get(Id.random());
    private List<ContestantState> contestantStates = IntStream.range(0, 10).boxed()
            .map(i -> {
                Player player = i % 2 == 0 ? main : opponent;
                return new ContestantState(player, RandomHelper.randomElement(player.allWisies()), Position.random(player.isMain()));
            }).collect(Collectors.toList());

    public Player getMain() {
        return main;
    }

    public Player getOpponent() {
        return opponent;
    }

    public List<ContestantState> getContestantStates() {
        return contestantStates;
    }

    Match build() {
        MatchMetadata metadata = new MatchMetadata(new Players(main, opponent));
        MatchState state = new MatchState(metadata);
        contestantStates.forEach(state::addContestantState);
        return new Match(Id.random(), state, metadata);
    }
}
