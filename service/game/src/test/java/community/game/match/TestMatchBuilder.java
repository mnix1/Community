package community.game.match;

import community.game.Id;
import community.game.RandomHelper;
import community.game.match.metadata.MatchMetadata;
import community.game.match.metadata.Player;
import community.game.match.metadata.Players;
import community.game.match.metadata.wisie.Wisie;
import community.game.match.metadata.wisie.stat.WisieStat;
import community.game.match.state.ContestantState;
import community.game.match.state.MatchState;
import community.game.match.state.Position;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestMatchBuilder {
    private Player main = new RandomMatchPlayerProvider().get(Id.random(), true);
    private Player opponent = new RandomMatchPlayerProvider().get(Id.random(), false);
    private List<ContestantState> contestantStates = IntStream.range(0, 10).boxed()
            .map(i -> {
                Player player = i % 2 == 0 ? main : opponent;
                Wisie wisie = RandomHelper.randomElement(player.allWisies());
                return new ContestantState(player, wisie, Position.random(player.isMain()))
                        .energy(wisie.getBaseStats().get(WisieStat.ENERGY_START).get())
                        .health(wisie.getBaseStats().get(WisieStat.HEALTH_START).get());
            }).collect(Collectors.toList());

    public TestMatchBuilder contestantStates(List<ContestantState> contestantStates) {
        this.contestantStates = contestantStates;
        return this;
    }

    public Player getMain() {
        return main;
    }

    public Player getOpponent() {
        return opponent;
    }

    public List<ContestantState> getContestantStates() {
        return contestantStates;
    }

    public ContestantState findContestantState(boolean main) {
        return contestantStates.stream().filter(c -> c.getPlayer().isMain() == main).findFirst().get();
    }

    Match build() {
        MatchMetadata metadata = new MatchMetadata(new Players(main, opponent), new Board());
        MatchState state = new MatchState(metadata);
        contestantStates.forEach(state::addContestant);
        return new Match(Id.random(), state, metadata);
    }
}
