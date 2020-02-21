package community.friend;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

import static java.time.Instant.now;

@RestController
class RelationController {
    private final RelationService relationService;

    RelationController(RelationService relationService) {
        this.relationService = relationService;
    }

    @PostMapping("/friends")
    @ResponseStatus(HttpStatus.CREATED)
    void addFriend(@AuthenticationPrincipal Jwt jwt, @RequestBody @Valid AddRelationRequestBody requestBody) {
        Friend friend = new Friend(jwt.getSubject(), requestBody.getUserId(), now());
        relationService.saveFriend(friend);
    }

    @GetMapping("/relations")
    Collection<Relation> getRelations(@AuthenticationPrincipal Jwt jwt) {
        return relationService.listRelations(jwt.getSubject());
    }

}
