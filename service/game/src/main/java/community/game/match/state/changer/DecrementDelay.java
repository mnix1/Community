package community.game.match.state.changer;

import community.game.match.metadata.MatchMetadata;
import community.game.match.state.MatchState;

public class DecrementDelay implements StateChanger {
    @Override
    public void apply(MatchState state, MatchMetadata metadata) {
        state.getContestantStates().forEach(c -> c.delay(c.getDelay() - 1));
    }

}
