package community.game.match;

import community.game.match.metadata.wisie.stat.ConstStatValueProvider;
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
        contestantState.getWisie().getBaseStats().add(WisieStat.ENERGY_REGEN, new ConstStatValueProvider(2));
        contestantState.getWisie().getBaseStats().add(WisieStat.ENERGY_MAX, new ConstStatValueProvider(10));
        contestantState.getWisie().getBaseStats().add(WisieStat.ATTACK_RANGE, new ConstStatValueProvider(-1));
        contestantState.getWisie().getBaseStats().add(WisieStat.MOVE_ENERGY_COST, new ConstStatValueProvider(1));
        contestantState.getWisie().getBaseStats().add(WisieStat.MOVE_RANGE, new ConstStatValueProvider(2));
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
        mainPlayerContestantState.getWisie().getBaseStats().add(WisieStat.ENERGY_MAX, new ConstStatValueProvider(101));
        mainPlayerContestantState.getWisie().getBaseStats().add(WisieStat.ENERGY_REGEN, new ConstStatValueProvider(1));
        mainPlayerContestantState.getWisie().getBaseStats().add(WisieStat.ATTACK_ENERGY_COST, new ConstStatValueProvider(101));
        mainPlayerContestantState.getWisie().getBaseStats().add(WisieStat.ATTACK_RANGE, new ConstStatValueProvider(1000));
        mainPlayerContestantState.getWisie().getBaseStats().add(WisieStat.ATTACK, new ConstStatValueProvider(5));
        ContestantState opponentPlayerContestantState = matchBuilder.findContestantState(false);
        opponentPlayerContestantState.health(6);
        opponentPlayerContestantState.getWisie().getBaseStats().add(WisieStat.HEALTH_MAX, new ConstStatValueProvider(10));
        opponentPlayerContestantState.getWisie().getBaseStats().add(WisieStat.HEALTH_REGEN, new ConstStatValueProvider(1));
        opponentPlayerContestantState.getWisie().getBaseStats().add(WisieStat.DEFEND, new ConstStatValueProvider(1));
        Match match = matchBuilder.contestantStates(List.of(mainPlayerContestantState, opponentPlayerContestantState)).build();

        match.nextTick();

        assertThat(mainPlayerContestantState.getEnergy()).isEqualTo(100 + 1 - 101);
        assertThat(opponentPlayerContestantState.getHealth()).isEqualTo(6 + 1 - 5 + 1);
    }

    @Test
    void noActionWhenNoEnergy() {
        TestMatchBuilder matchBuilder = new TestMatchBuilder();
        ContestantState mainPlayerContestantState = matchBuilder.findContestantState(true);
        mainPlayerContestantState.energy(1);
        mainPlayerContestantState.position(new Position(true, 1, 0));
        mainPlayerContestantState.getWisie().getBaseStats().add(WisieStat.ENERGY_REGEN, new ConstStatValueProvider(1));
        mainPlayerContestantState.getWisie().getBaseStats().add(WisieStat.ATTACK_ENERGY_COST, new ConstStatValueProvider(3));
        mainPlayerContestantState.getWisie().getBaseStats().add(WisieStat.ATTACK, new ConstStatValueProvider(3));
        mainPlayerContestantState.getWisie().getBaseStats().add(WisieStat.MOVE_ENERGY_COST, new ConstStatValueProvider(3));
        ContestantState opponentPlayerContestantState = matchBuilder.findContestantState(false);
        opponentPlayerContestantState.health(6);
        opponentPlayerContestantState.energy(5);
        opponentPlayerContestantState.getWisie().getBaseStats().add(WisieStat.ENERGY_MAX, new ConstStatValueProvider(6));
        opponentPlayerContestantState.getWisie().getBaseStats().add(WisieStat.ENERGY_REGEN, new ConstStatValueProvider(2));
        opponentPlayerContestantState.getWisie().getBaseStats().add(WisieStat.HEALTH_REGEN, new ConstStatValueProvider(0));
        opponentPlayerContestantState.getWisie().getBaseStats().add(WisieStat.DEFEND, new ConstStatValueProvider(0));
        opponentPlayerContestantState.getWisie().getBaseStats().add(WisieStat.MOVE_ENERGY_COST, new ConstStatValueProvider(7));
        opponentPlayerContestantState.getWisie().getBaseStats().add(WisieStat.ATTACK_ENERGY_COST, new ConstStatValueProvider(7));
        Match match = matchBuilder.contestantStates(List.of(mainPlayerContestantState, opponentPlayerContestantState)).build();

        match.nextTick();

        assertThat(mainPlayerContestantState.getEnergy()).isEqualTo(2);
        assertThat(mainPlayerContestantState.getPosition()).isEqualTo(new Position(true, 1, 0));
        assertThat(opponentPlayerContestantState.getHealth()).isEqualTo(6);
        assertThat(opponentPlayerContestantState.getEnergy()).isEqualTo(6);
    }
}