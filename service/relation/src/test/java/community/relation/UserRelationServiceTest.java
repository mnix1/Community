package community.relation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static java.time.Instant.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@ExtendWith(value = {SpringExtension.class})
//@SpringBootTest
class UserRelationServiceTest {
    private RelationService relationService;
    private UserRelationService userRelationService;

    @BeforeEach
    void setUp() {
        relationService = mock(RelationService.class);
        userRelationService = new UserRelationService(relationService);
    }

    @Test
    void returnsUserRelations() {
        String u1Id = "11111111-1111-1111-1111-111111111111";
        String u2Id = "22222222-2222-2222-2222-222222222222";
        String u3Id = "33333333-3333-3333-3333-333333333333";
        String u4Id = "44444444-4444-4444-4444-444444444444";
        Set<Relation> relations = Set.of(
                new Relation(u1Id, u2Id, now()),
                new Relation(u2Id, u1Id, now()),
                new Relation(u1Id, u3Id, now()),
                new Relation(u4Id, u1Id, now())
        );
        when(relationService.list(anyString())).thenReturn(relations);

        assertThat(userRelationService.list(u1Id)).containsExactlyInAnyOrder(
                new UserRelation(u2Id, true, true),
                new UserRelation(u3Id, true, false),
                new UserRelation(u4Id, false, true)
        );
    }
}