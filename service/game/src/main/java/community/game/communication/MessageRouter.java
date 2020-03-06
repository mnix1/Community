package community.game.communication;

import community.game.action.ActionHandler;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

@Service
public class MessageRouter {
    private final Collection<ActionHandler> actionHandlers;

    public MessageRouter(Collection<ActionHandler> actionHandlers) {
        this.actionHandlers = actionHandlers;
    }

    Mono<Void> handle(String message) {
        return Flux.fromIterable(actionHandlers)
                .filter(a -> a.canHandle(message))
                .next()
                .flatMap(a -> Mono.just(message).map(a::toAction).flatMap(a::handle));
    }
}
