package community.game.match.metadata.wisie.interaction.controller;

import community.game.match.Match;
import community.game.match.metadata.wisie.interaction.Interaction;
import community.game.match.state.ContestantState;

import java.util.List;

public interface InteractionController {
    List<Interaction> interactions(ContestantState source, Match match);
}
