package community.game.match.play;

import java.time.Instant;

public class ProcessedPlay {
    protected final Play play;
    protected final Instant processed;

    public ProcessedPlay(Play play, Instant processed) {
        this.play = play;
        this.processed = processed;
    }

    public Play getPlay() {
        return play;
    }

    public Instant getProcessed() {
        return processed;
    }
}
