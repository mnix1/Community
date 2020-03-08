package community.game;

import community.game.match.Match;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MatchService {
    private Map<Id, Match> matches = new ConcurrentHashMap<>();
    private UserService userService;

    public Id createMatch(Id main, Id opponent){
        return Id.random();
    }
}
