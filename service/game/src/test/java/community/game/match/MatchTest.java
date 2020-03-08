package community.game.match;

import community.game.match.metadata.contestant.Contestant;
import community.game.match.state.ContestantState;
import community.game.match.state.MatchState;
import community.game.match.metadata.wisie.WisieType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {
    @Test
    void decrementDelay() {
        int delay = 3;
        TestMatchBuilder matchBuilder = new TestMatchBuilder();
        Contestant contestant = new TestContestantBuilder(matchBuilder.getFirstTeamId())
                .wisie(new TestWisieBuilder(WisieType.BULLO).build()).build();
        MatchState state = new MatchState().addContestantState(new ContestantState(contestant).delay(delay));
        Match match = matchBuilder.teamContestant(contestant).state(state).build();

        match.nextTick();

        assertThat(match.getState().getTick()).isEqualTo(1);
        assertThat(match.getState().contestantState(contestant.getId()).map(ContestantState::getDelay)).contains(2);
    }
}