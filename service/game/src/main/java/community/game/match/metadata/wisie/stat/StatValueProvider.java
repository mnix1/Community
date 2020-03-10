package community.game.match.metadata.wisie.stat;

import community.game.match.Args;

public interface StatValueProvider {
    StatValueProviderType getType();

    default int get(Args args) {
        return get();
    }

    int get();
}
