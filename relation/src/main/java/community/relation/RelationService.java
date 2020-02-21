package community.relation;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
class RelationService {
    private final RelationRepository relationRepository;

    RelationService(RelationRepository relationRepository) {
        this.relationRepository = relationRepository;
    }

    Set<Relation> list(String id) {
        return relationRepository.find(id);
    }

    void add(Relation relation) {
        relationRepository.save(relation);
    }
}
