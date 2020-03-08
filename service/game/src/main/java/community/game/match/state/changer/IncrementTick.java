package community.game.match.state.changer;

import community.game.match.metadata.MatchMetadata;
import community.game.match.state.MatchState;

public class IncrementTick implements StateChanger {
    @Override
    public void apply(MatchState state, MatchMetadata metadata) {
        state.tick(state.getTick() + 1);
    }

}
