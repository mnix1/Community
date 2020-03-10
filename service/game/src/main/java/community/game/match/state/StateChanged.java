package community.game.match.state;

import community.game.match.state.changer.StateChanger;

import java.time.Instant;
import java.util.List;

public class StateChanged {
    private final List<StateChanger> stateChangers;
    private final Instant applied;

    public StateChanged(List<StateChanger> stateChangers, Instant applied) {
        this.stateChangers = stateChangers;
        this.applied = applied;
    }

    public List<StateChanger> getStateChangers() {
        return stateChangers;
    }

    public Instant getApplied() {
        return applied;
    }
}
