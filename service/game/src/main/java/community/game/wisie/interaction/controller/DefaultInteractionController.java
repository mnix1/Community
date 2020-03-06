package community.game.wisie.interaction.controller;

import community.game.match.Contestant;
import community.game.match.Id;
import community.game.match.InteractionType;
import community.game.wisie.interaction.Interaction;
import community.game.wisie.interaction.MoveInteraction;

import java.util.List;
import java.util.Map;

public class DefaultInteractionController implements InteractionController {
    @Override
    public List<Interaction> interactions(Id source, Map<Id, Contestant> contestants) {
        if(canAttackOpponent()){
            return List.of(new AttackIntera)
        }
        return List.of(new MoveInteraction(source, ));
    }


}
