package community.relation;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
class UserRelationService {
    private final RelationService relationService;

    UserRelationService(RelationService relationService) {
        this.relationService = relationService;
    }

    Set<UserRelation> list(String id) {
        Set<Relation> relations = relationService.list(id);
        Set<String> fromId = relations.stream().filter(f -> f.getRequesterId().equals(id)).map(Relation::getTargetId).collect(Collectors.toSet());
        Set<String> toId = relations.stream().filter(f -> f.getTargetId().equals(id)).map(Relation::getRequesterId).collect(Collectors.toSet());
        return relations.stream()
                .map(f -> f.getRequesterId().equals(id)
                        ? new UserRelation(f.getTargetId(), fromId.contains(f.getTargetId()), toId.contains(f.getTargetId()))
                        : new UserRelation(f.getRequesterId(), fromId.contains(f.getRequesterId()), toId.contains(f.getRequesterId()))
                )
                .collect(Collectors.toSet());

    }
}
