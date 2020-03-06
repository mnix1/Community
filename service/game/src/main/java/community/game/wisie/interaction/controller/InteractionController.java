package community.game.wisie.interaction.controller;

import community.game.match.Contestant;
import community.game.match.Contestants;
import community.game.match.Id;
import community.game.wisie.interaction.Interaction;

import java.util.List;

public interface InteractionController {
    List<Interaction> interactions(Contestant source, Contestants contestants);
}
