package community.game.wisie.interaction.controller;

import community.game.contestant.Contestant;
import community.game.contestant.Contestants;
import community.game.wisie.interaction.Interaction;

import java.util.List;

public interface InteractionController {
    List<Interaction> interactions(Contestant source, Contestants contestants);
}
