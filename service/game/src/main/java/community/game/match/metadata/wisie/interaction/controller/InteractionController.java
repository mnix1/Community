package community.game.match.metadata.wisie.interaction.controller;

import community.game.match.metadata.MatchMetadata;
import community.game.match.metadata.wisie.interaction.Interaction;
import community.game.match.state.ContestantState;
import community.game.match.state.MatchState;

import java.util.List;

public interface InteractionController {
    List<Interaction> interactions(ContestantState source, MatchState state, MatchMetadata metadata);
}
