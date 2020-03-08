package community.game.match.metadata;

import community.game.Id;
import community.game.match.metadata.wisie.Wisie;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Player {
    private final Id id;
    private final Id teamId;
    private final boolean main;
    private final Map<Id, Wisie> wisies;
    private final int maxEnergy;
    private final int startEnergy;

    public Player(Id id, Id teamId, boolean main, List<Wisie> wisies, int maxEnergy, int startEnergy) {
        this.id = id;
        this.teamId = teamId;
        this.main = main;
        this.wisies = wisies.stream().collect(Collectors.toMap(Wisie::getId, p -> p));
        this.maxEnergy = maxEnergy;
        this.startEnergy = startEnergy;
    }

    public Id getId() {
        return id;
    }

    public Id getTeamId() {
        return teamId;
    }

    public boolean isMain() {
        return main;
    }

    public Optional<Wisie> getWisie(Id id) {
        return Optional.ofNullable(wisies.get(id));
    }

    public Collection<Wisie> allWisies() {
        return wisies.values();
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public int getStartEnergy() {
        return startEnergy;
    }
}
