package community.game.match.state;

import community.game.match.state.changer.IncrementTick;
import community.game.match.state.changer.PlayContestant;
import community.game.match.state.changer.StateChanger;

import java.util.ArrayList;
import java.util.List;

public class NextTickChangers {
    public List<StateChanger> get() {
        List<StateChanger> commands = new ArrayList<>();
        commands.add(new IncrementTick());
        commands.add(new PlayContestant());
        return commands;
    }


}
