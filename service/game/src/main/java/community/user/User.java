package community.user;

import java.time.Instant;

public class User {
    private final String id;
    private final Instant lastSignIn;

    public User(String id, Instant lastSignIn) {
        this.id = id;
        this.lastSignIn = lastSignIn;
    }

    public String getId() {
        return id;
    }

    public Instant getLastSignIn() {
        return lastSignIn;
    }
}
