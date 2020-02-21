package community.friend;

import java.time.Instant;

class Friend {
    private final String id;
    private final String friendId;
    private final Instant created;

    Friend(String id, String friendId, Instant created) {
        this.id = id;
        this.friendId = friendId;
        this.created = created;
    }

    public String getId() {
        return id;
    }

    public String getFriendId() {
        return friendId;
    }

    public Instant getCreated() {
        return created;
    }
}
