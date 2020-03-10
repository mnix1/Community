package community.game.match.play;

import community.game.Id;
import community.game.match.metadata.MatchMetadata;
import community.game.match.state.MatchState;
import community.game.match.state.changer.StateChanger;

import java.time.Instant;
import java.util.List;

public abstract class Play {
    protected final Id playerId;
    protected final Instant created;
    protected final PlayType type;

    protected Play(Id playerId, Instant created, PlayType type) {
        this.playerId = playerId;
        this.created = created;
        this.type = type;
    }

    public Id getPlayerId() {
        return playerId;
    }

    public Instant getCreated() {
        return created;
    }

    public PlayType getType() {
        return type;
    }

    public abstract boolean canPlay(MatchState state, MatchMetadata metadata);

    public abstract List<StateChanger> toStateChangers(MatchState state, MatchMetadata metadata);
}
