package community.relation;

import java.time.Instant;

class Relation {
    private final String requesterId;
    private final String targetId;
    private final Instant created;

    Relation(String requesterId, String targetId, Instant created) {
        this.requesterId = requesterId;
        this.targetId = targetId;
        this.created = created;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public String getTargetId() {
        return targetId;
    }

    public Instant getCreated() {
        return created;
    }
}
