package community.friend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.time.Instant.now;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

//@ExtendWith(value = {SpringExtension.class})
//@SpringBootTest
class RelationServiceTest {
    private FriendRepository friendRepository;
    private RelationService relationService;

    @BeforeEach
    void setUp() {
        friendRepository = mock(FriendRepository.class);
        relationService = new RelationService(friendRepository);
    }

    @Test
    void returnsRelations() {
        String u1Id = "11111111-1111-1111-1111-111111111111";
        String u2Id = "22222222-2222-2222-2222-222222222222";
        String u3Id = "33333333-3333-3333-3333-333333333333";
        String u4Id = "44444444-4444-4444-4444-444444444444";
        List<Friend> friends = List.of(
                new Friend(u1Id, u2Id, now()),
                new Friend(u2Id, u1Id, now()),
                new Friend(u1Id, u3Id, now()),
                new Friend(u4Id, u1Id, now())
        );
        when(friendRepository.getByIdOrFriendId(anyString())).thenReturn(friends);

        assertThat(relationService.listRelations(u1Id)).containsExactlyInAnyOrder(
                new Relation(u2Id, true, true),
                new Relation(u3Id, true, false),
                new Relation(u4Id, false, true)
        );
    }
}