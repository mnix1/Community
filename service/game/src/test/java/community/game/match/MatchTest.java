package community.game.match;

import community.game.match.metadata.wisie.stat.ConstWisieStatValueProvider;
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
        contestantState.getWisie().getStats().add(WisieStat.ENERGY_REGEN, new ConstWisieStatValueProvider(2));
        contestantState.getWisie().getStats().add(WisieStat.ENERGY_MAX, new ConstWisieStatValueProvider(10));
        contestantState.getWisie().getStats().add(WisieStat.ATTACK_RANGE, new ConstWisieStatValueProvider(-1));
        contestantState.getWisie().getStats().add(WisieStat.MOVE_ENERGY_COST, new ConstWisieStatValueProvider(1));
        contestantState.getWisie().getStats().add(WisieStat.MOVE_RANGE, new ConstWisieStatValueProvider(2));
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
        mainPlayerContestantState.getWisie().getStats().add(WisieStat.ENERGY_MAX, new ConstWisieStatValueProvider(101));
        mainPlayerContestantState.getWisie().getStats().add(WisieStat.ENERGY_REGEN, new ConstWisieStatValueProvider(1));
        mainPlayerContestantState.getWisie().getStats().add(WisieStat.ATTACK_ENERGY_COST, new ConstWisieStatValueProvider(101));
        mainPlayerContestantState.getWisie().getStats().add(WisieStat.ATTACK_RANGE, new ConstWisieStatValueProvider(1000));
        mainPlayerContestantState.getWisie().getStats().add(WisieStat.ATTACK, new ConstWisieStatValueProvider(5));
        ContestantState opponentPlayerContestantState = matchBuilder.findContestantState(false);
        opponentPlayerContestantState.health(6);
        opponentPlayerContestantState.getWisie().getStats().add(WisieStat.HEALTH_MAX, new ConstWisieStatValueProvider(10));
        opponentPlayerContestantState.getWisie().getStats().add(WisieStat.HEALTH_REGEN, new ConstWisieStatValueProvider(1));
        opponentPlayerContestantState.getWisie().getStats().add(WisieStat.DEFEND, new ConstWisieStatValueProvider(1));
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
        mainPlayerContestantState.getWisie().getStats().add(WisieStat.ENERGY_REGEN, new ConstWisieStatValueProvider(1));
        mainPlayerContestantState.getWisie().getStats().add(WisieStat.ATTACK_ENERGY_COST, new ConstWisieStatValueProvider(3));
        mainPlayerContestantState.getWisie().getStats().add(WisieStat.ATTACK, new ConstWisieStatValueProvider(3));
        mainPlayerContestantState.getWisie().getStats().add(WisieStat.MOVE_ENERGY_COST, new ConstWisieStatValueProvider(3));
        ContestantState opponentPlayerContestantState = matchBuilder.findContestantState(false);
        opponentPlayerContestantState.health(6);
        opponentPlayerContestantState.energy(5);
        opponentPlayerContestantState.getWisie().getStats().add(WisieStat.ENERGY_MAX, new ConstWisieStatValueProvider(6));
        opponentPlayerContestantState.getWisie().getStats().add(WisieStat.ENERGY_REGEN, new ConstWisieStatValueProvider(2));
        opponentPlayerContestantState.getWisie().getStats().add(WisieStat.HEALTH_REGEN, new ConstWisieStatValueProvider(0));
        opponentPlayerContestantState.getWisie().getStats().add(WisieStat.DEFEND, new ConstWisieStatValueProvider(0));
        opponentPlayerContestantState.getWisie().getStats().add(WisieStat.MOVE_ENERGY_COST, new ConstWisieStatValueProvider(7));
        opponentPlayerContestantState.getWisie().getStats().add(WisieStat.ATTACK_ENERGY_COST, new ConstWisieStatValueProvider(7));
        Match match = matchBuilder.contestantStates(List.of(mainPlayerContestantState, opponentPlayerContestantState)).build();

        match.nextTick();

        assertThat(mainPlayerContestantState.getEnergy()).isEqualTo(2);
        assertThat(mainPlayerContestantState.getPosition()).isEqualTo(new Position(true, 1, 0));
        assertThat(opponentPlayerContestantState.getHealth()).isEqualTo(6);
        assertThat(opponentPlayerContestantState.getEnergy()).isEqualTo(6);
    }
}