package community.game.wisie.interaction.controller;

import community.game.match.Contestant;
import community.game.match.Id;
import community.game.wisie.interaction.Interaction;

import java.util.List;
import java.util.Map;

public interface InteractionController {
    List<Interaction> interactions(Id source, Map<Id, Contestant> contestants);
}
