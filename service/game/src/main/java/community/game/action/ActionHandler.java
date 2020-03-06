package community.game.action;

import reactor.core.publisher.Mono;

public interface ActionHandler {
    Mono<Void> handle(Action action);

    Action toAction(String message);

    boolean canHandle(String message);
}
