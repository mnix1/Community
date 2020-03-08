package community.game.match.metadata.wisie.interaction.controller;

import community.game.match.Args;
import community.game.match.metadata.wisie.interaction.Interaction;

import java.util.List;

public interface InteractionController {
    List<Interaction> interactions(Args args);
}
