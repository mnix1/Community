package community.relation;

import java.util.Objects;

class UserRelation {
    private final String targetId;
    private final boolean accepted;
    private final boolean acceptedByTarget;

    UserRelation(String targetId, boolean accepted, boolean acceptedByTarget) {
        this.targetId = targetId;
        this.accepted = accepted;
        this.acceptedByTarget = acceptedByTarget;
    }

    public String getTargetId() {
        return targetId;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public boolean isAcceptedByTarget() {
        return acceptedByTarget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserRelation userRelation = (UserRelation) o;
        return accepted == userRelation.accepted &&
                acceptedByTarget == userRelation.acceptedByTarget &&
                Objects.equals(targetId, userRelation.targetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(targetId, accepted, acceptedByTarget);
    }

    @Override
    public String toString() {
        return "Relation{" +
                "friendId='" + targetId + '\'' +
                ", accepted=" + accepted +
                ", acceptedByFriend=" + acceptedByTarget +
                '}';
    }
}
