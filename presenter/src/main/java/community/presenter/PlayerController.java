package community.presenter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
public class PlayerController {
    @GetMapping("/players")
    public Collection<Player> players() {
        return IntStream.rangeClosed(0, new Random().nextInt(10))
                .boxed().map(i -> Player.random())
                .collect(Collectors.toList());
    }
}
