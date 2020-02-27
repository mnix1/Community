package community.presenter;

import java.time.Instant;
import java.util.List;
import java.util.Random;

import static java.time.Instant.now;
import static java.util.UUID.randomUUID;
import static community.presenter.Screen.values;

public class Player {
    private final String id;
    private final String name;
    private final Screen screen;
    private final Instant sessionStartDateTime;
    private final Instant lastActionDateTime;

    public static Player random() {
        List<String> names = List.of("Kamil", "Łukasz", "Adam", "Hubert", "Tomek", "Marcin", "Michał", "Marta", "Ewelina", "Kasia", "Krzysiek", "Ola", "Mateusz");
        Random random = new Random();
        return new Player(
                randomUUID().toString(),
                names.get(random.nextInt(names.size())),
                values()[random.nextInt(values().length)],
                now().minusSeconds(random.nextInt(1000) + 100),
                now().minusSeconds(99)
        );
    }

    public Player(String id, String name, Screen screen, Instant sessionStartDateTime, Instant lastActionDateTime) {
        this.id = id;
        this.name = name;
        this.screen = screen;
        this.sessionStartDateTime = sessionStartDateTime;
        this.lastActionDateTime = lastActionDateTime;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Screen getScreen() {
        return screen;
    }

    public Instant getSessionStartDateTime() {
        return sessionStartDateTime;
    }

    public Instant getLastActionDateTime() {
        return lastActionDateTime;
    }
}
