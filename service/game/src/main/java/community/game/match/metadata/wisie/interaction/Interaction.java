package community.game.match.metadata.wisie.interaction;

public interface Interaction {
    InteractionType type();

    void invoke();
}
