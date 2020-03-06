package community.game.communication;

import org.reactivestreams.Publisher;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Mono;

@Service
class CommunicationHandler implements WebSocketHandler {
    private final MessageRouter messageRouter;

    CommunicationHandler(MessageRouter messageRouter) {
        this.messageRouter = messageRouter;
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        return session.receive()
                .map(WebSocketMessage::getPayloadAsText)
                .flatMap(m -> processMessage(session, m))
                .then();
    }

    private Publisher<? extends Void> processMessage(WebSocketSession session, String message) {
        if (message.equals("PING")) {
            return session.send(Mono.just(session.textMessage(message)));
        }
        return messageRouter.handle(message);
    }
}