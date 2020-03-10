package community.game.match.metadata;

import community.game.Id;
import community.game.NotFoundException;
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
    private final int energyMax;
    private final int energyStart;
    private final int energyRegen;

    public Player(Id id, Id teamId, boolean main, List<Wisie> wisies, int energyMax, int energyStart, int energyRegen) {
        this.id = id;
        this.teamId = teamId;
        this.main = main;
        this.wisies = wisies.stream().collect(Collectors.toMap(Wisie::getId, p -> p));
        this.energyMax = energyMax;
        this.energyStart = energyStart;
        this.energyRegen = energyRegen;
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

    public Optional<Wisie> findWisie(Id id) {
        return Optional.ofNullable(wisies.get(id));
    }

    public Wisie getWisie(Id id) {
        return findWisie(id).orElseThrow(() -> new NotFoundException("getWisie Id=" + id));
    }

    public Collection<Wisie> allWisies() {
        return wisies.values();
    }

    public int getEnergyMax() {
        return energyMax;
    }

    public int getEnergyStart() {
        return energyStart;
    }

    public int getEnergyRegen() {
        return energyRegen;
    }
}
