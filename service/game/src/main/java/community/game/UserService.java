package community.game;

import community.game.match.metadata.wisie.Wisie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    List<Wisie> userWisies(Id id) {
        return List.of(new Wisie());
    }
}
