package community.relation;

import java.util.Objects;

class UserRelation {
    private final String friendId;
    private final boolean accepted;
    private final boolean acceptedByFriend;

    UserRelation(String friendId, boolean accepted, boolean acceptedByFriend) {
        this.friendId = friendId;
        this.accepted = accepted;
        this.acceptedByFriend = acceptedByFriend;
    }

    public String getFriendId() {
        return friendId;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public boolean isAcceptedByFriend() {
        return acceptedByFriend;
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
                acceptedByFriend == userRelation.acceptedByFriend &&
                Objects.equals(friendId, userRelation.friendId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(friendId, accepted, acceptedByFriend);
    }

    @Override
    public String toString() {
        return "Relation{" +
                "friendId='" + friendId + '\'' +
                ", accepted=" + accepted +
                ", acceptedByFriend=" + acceptedByFriend +
                '}';
    }
}
