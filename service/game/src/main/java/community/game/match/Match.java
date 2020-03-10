package community.game.match;

import community.game.Id;
import community.game.match.metadata.MatchMetadata;
import community.game.match.play.Play;
import community.game.match.play.ProcessedPlay;
import community.game.match.state.MatchState;
import community.game.match.state.NextTickChangers;
import community.game.match.state.StateChanged;
import community.game.match.state.changer.StateChanger;

import java.util.ArrayList;
import java.util.List;

import static java.time.Instant.now;

public class Match {
    private final Id id;
    private final List<StateChanged> stateChanges = new ArrayList<>();
    private final List<ProcessedPlay> processedPlays = new ArrayList<>();
    private final MatchState state;
    private final MatchMetadata metadata;

    public Match(Id id, MatchState state, MatchMetadata metadata) {
        this.id = id;
        this.state = state;
        this.metadata = metadata;
    }

    public synchronized void nextTick() {
        execute(new NextTickChangers().get());
    }

    public synchronized void play(Play play) {
        if (!play.canPlay(state, metadata)) {
            return;
        }
        execute(play.toStateChangers(state, metadata));
        processedPlays.add(new ProcessedPlay(play, now()));
    }

    public void execute(List<StateChanger> stateChangers) {
        stateChangers.forEach(s -> s.apply(state, metadata));
        this.stateChanges.add(new StateChanged(stateChangers, now()));
    }

    public MatchState getState() {
        return state;
    }

    public MatchMetadata getMetadata() {
        return metadata;
    }

    public List<StateChanged> getStateChanges() {
        return stateChanges;
    }

    public List<ProcessedPlay> getProcessedPlays() {
        return processedPlays;
    }

    public Id getId() {
        return id;
    }
}
