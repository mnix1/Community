package community.game.match;

import community.game.match.state.ContestantState;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {
    @Test
    void decrementDelay() {
        TestMatchBuilder matchBuilder = new TestMatchBuilder();
        ContestantState contestantState = matchBuilder.getContestantStates().stream().findFirst().get();
        contestantState.delay(1);
        Match match = matchBuilder.build();

        match.nextTick();

        assertThat(match.getState().getTick()).isEqualTo(1);
        assertThat(match.getState().findContestantState(contestantState.getId()).map(ContestantState::getDelay)).contains(0);
    }
}