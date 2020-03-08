package community.game.match;

import community.game.Id;
import community.game.match.metadata.MatchMetadata;
import community.game.match.state.MatchState;
import community.game.match.state.NextTickChangers;
import community.game.match.state.changer.StateChanger;

import java.util.ArrayList;
import java.util.List;

public class Match {
    private final Id id;
    private final List<StateChanger> allStateChangers = new ArrayList<>();
    private final MatchState state;
    private final MatchMetadata metadata;

    public Match(Id id, MatchState state, MatchMetadata metadata) {
        this.id = id;
        this.state = state;
        this.metadata = metadata;
    }

    public void nextTick() {
        List<StateChanger> changers = new NextTickChangers().get();
        execute(changers);
        allStateChangers.addAll(changers);
    }

    public void play(Id playerId) {

    }

    private void execute(List<StateChanger> changers) {
        changers.forEach(s -> s.apply(state, metadata));
    }

    public MatchState getState() {
        return state;
    }

    public MatchMetadata getMetadata() {
        return metadata;
    }

    public Id getId() {
        return id;
    }
}
