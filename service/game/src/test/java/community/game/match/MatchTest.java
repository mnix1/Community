package community.game.match;

import community.game.match.metadata.wisie.stat.WisieStat;
import community.game.match.state.ContestantState;
import community.game.match.state.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MatchTest {
    @Test
    void regenEnergyAndMove() {
        TestMatchBuilder matchBuilder = new TestMatchBuilder();
        ContestantState contestantState = matchBuilder.findContestantState(true);
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
        assertThat(contestantState.getEnergy()).isEqualTo(1 + 2 - 1);
        assertThat(contestantState.getPosition()).isEqualTo(new Position(true, 1 + 2, 0));
    }

    @Test
    void regenHealthAndAttack() {
        TestMatchBuilder matchBuilder = new TestMatchBuilder();
        ContestantState mainPlayerContestantState = matchBuilder.findContestantState(true);
        mainPlayerContestantState.energy(100);
        mainPlayerContestantState.getWisie().getBaseStats().add(WisieStat.ENERGY_REGEN, () -> 0);
        mainPlayerContestantState.getWisie().getBaseStats().add(WisieStat.ATTACK_ENERGY_COST, () -> 69);
        mainPlayerContestantState.getWisie().getBaseStats().add(WisieStat.ATTACK_RANGE, () -> 1000);
        mainPlayerContestantState.getWisie().getBaseStats().add(WisieStat.ATTACK, () -> 5);
        ContestantState opponentPlayerContestantState = matchBuilder.findContestantState(false);
        opponentPlayerContestantState.health(6);
        opponentPlayerContestantState.getWisie().getBaseStats().add(WisieStat.HEALTH_MAX, () -> 10);
        opponentPlayerContestantState.getWisie().getBaseStats().add(WisieStat.HEALTH_REGEN, () -> 1);
        opponentPlayerContestantState.getWisie().getBaseStats().add(WisieStat.DEFEND, () -> 1);
        Match match = matchBuilder.contestantStates(List.of(mainPlayerContestantState, opponentPlayerContestantState)).build();

        match.nextTick();

        assertThat(mainPlayerContestantState.getEnergy()).isEqualTo(100 - 69);
        assertThat(opponentPlayerContestantState.getHealth()).isEqualTo(6 + 1 - 5 + 1);
    }
}