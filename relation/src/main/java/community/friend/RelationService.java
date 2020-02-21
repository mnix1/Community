package community.friend;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
class RelationService {
    private final FriendRepository friendRepository;

    RelationService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    Set<Relation> listRelations(String id) {
        List<Friend> friends = friendRepository.getByIdOrFriendId(id);
        Set<String> fromId = friends.stream().filter(f -> f.getId().equals(id)).map(Friend::getFriendId).collect(Collectors.toSet());
        Set<String> toId = friends.stream().filter(f -> f.getFriendId().equals(id)).map(Friend::getId).collect(Collectors.toSet());
        return friends.stream()
                .map(f -> f.getId().equals(id)
                        ? new Relation(f.getFriendId(), fromId.contains(f.getFriendId()), toId.contains(f.getFriendId()))
                        : new Relation(f.getId(), fromId.contains(f.getId()), toId.contains(f.getId()))
                )
                .collect(Collectors.toSet());

    }

    void saveFriend(Friend friend) {
        friendRepository.save(friend);
    }
}
