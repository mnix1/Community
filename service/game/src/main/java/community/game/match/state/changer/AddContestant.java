package community.game.match.state.changer;

import community.game.match.Match;
import community.game.match.state.ContestantState;

public class AddContestant implements StateChanger {
    private final ContestantState contestantState;

    public AddContestant(ContestantState contestantState) {
        this.contestantState = contestantState;
    }

    @Override
    public void apply(Match match) {
        match.getState().addContestant(contestantState);
    }
}
