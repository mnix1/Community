package community.game.match;

import community.game.match.metadata.wisie.stat.WisieStat;
import community.game.match.state.ContestantState;
import community.game.match.state.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {
    @Test
    void increaseEnergyAndMove() {
        TestMatchBuilder matchBuilder = new TestMatchBuilder();
        ContestantState contestantState = matchBuilder.getContestantStates().stream().findFirst().get();
        contestantState.energy(1);
        contestantState.position(new Position(true, 1, 0));
        contestantState.getWisie().getBaseStats().add(WisieStat.ENERGY_REGEN, () -> 2);
        contestantState.getWisie().getBaseStats().add(WisieStat.ENERGY_MAX, () -> 10);
        contestantState.getWisie().getBaseStats().add(WisieStat.ATTACK_RANGE, () -> -1);
        contestantState.getWisie().getBaseStats().add(WisieStat.MOVE_ENERGY_COST, () -> 1);
        contestantState.getWisie().getBaseStats().add(WisieStat.MOVE_RANGE, () -> 2);
        Match match = matchBuilder.contestantStates(List.of(contestantState)).build();

        match.nextTick();

        assertThat(match.getState().getTick()).isEqualTo(1);
        assertThat(match.getState().getContestantState(contestantState.getId()).getEnergy()).isEqualTo(1 + 2 - 1);
        assertThat(match.getState().getContestantState(contestantState.getId()).getPosition()).isEqualTo(new Position(true, 1 + 2, 0));
    }
}