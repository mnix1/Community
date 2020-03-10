package community.game.match.metadata;

import community.game.match.Match;
import community.game.match.state.PlayerState;

import static community.game.match.metadata.PlayerStatValueProviderType.CONST_VALUE;


public class ConstPlayerStatValueProvider implements PlayerStatValueProvider {
    private final int value;

    public ConstPlayerStatValueProvider(int value) {
        this.value = value;
    }

    @Override
    public PlayerStatValueProviderType getType() {
        return CONST_VALUE;
    }

    @Override
    public int get(PlayerState source, Match match) {
        return value;
    }

}
