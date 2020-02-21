package community.relation;

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
    private final UserRelationService userRelationService;

    RelationController(RelationService relationService, UserRelationService userRelationService) {
        this.relationService = relationService;
        this.userRelationService = userRelationService;
    }

    @PostMapping("/relations")
    @ResponseStatus(HttpStatus.CREATED)
    void addRelation(@AuthenticationPrincipal Jwt jwt, @RequestBody @Valid AddRelationRequestBody requestBody) {
        Relation relation = new Relation(jwt.getSubject(), requestBody.getId(), now());
        relationService.add(relation);
    }

    @GetMapping("/relations")
    Collection<UserRelation> getUserRelations(@AuthenticationPrincipal Jwt jwt) {
        return userRelationService.list(jwt.getSubject());
    }

}
