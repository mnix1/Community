package community.game.match;

import community.game.Id;
import community.game.match.metadata.MatchMetadata;
import community.game.match.metadata.Players;
import community.game.match.metadata.contestant.Contestant;
import community.game.match.metadata.contestant.Contestants;
import community.game.match.metadata.contestant.TeamContestants;
import community.game.match.state.MatchState;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestMatchBuilder {
    private MatchState state;
    private Players players;
    private Id firstTeamId = Id.random();
    private Id secondTeamId = Id.random();
    private List<Contestant> firstTeamContestants = new ArrayList<>();
    private List<Contestant> secondTeamContestants = new ArrayList<>();

    public TestMatchBuilder state(MatchState state) {
        this.state = state;
        return this;
    }

    public TestMatchBuilder teamContestant(Contestant contestant) {
        if (firstTeamId.equals(contestant.getPlayerId())) {
            this.firstTeamContestants.add(contestant);
        } else if (secondTeamId.equals(contestant.getPlayerId())) {
            this.secondTeamContestants.add(contestant);
        } else {
            throw new IllegalArgumentException("Wrong teamId: " + contestant.getPlayerId());
        }
        return this;
    }

    public Match build() {
        return new Match(id, state, new MatchMetadata(players, new Contestants(Map.of(firstTeamId, teamContestants(firstTeamId, firstTeamContestants), secondTeamId, teamContestants(secondTeamId, secondTeamContestants)))));
    }

    private TeamContestants teamContestants(Id teamId, List<Contestant> contestants) {
        return new TeamContestants(teamId, contestants.stream().collect(Collectors.toMap(Contestant::getId, c -> c)));
    }

    public Id getFirstTeamId() {
        return firstTeamId;
    }

    public Id getSecondTeamId() {
        return secondTeamId;
    }
}
