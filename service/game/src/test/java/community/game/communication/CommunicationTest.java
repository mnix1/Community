package community.game.communication;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.ReplayProcessor;

import java.net.URI;
import java.net.URISyntaxException;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class CommunicationTest {
    @LocalServerPort
    private String port;
    @SpyBean
    private MessageRouter messageRouter;

    @Test
    public void receivesMessages() throws Exception {
        int count = 2;
        Flux<String> pings = Flux.range(1, count).map(i -> "PING");
        Flux<String> input = pings.mergeWith(Flux.just("test", "action"));
        ReplayProcessor<Object> output = ReplayProcessor.create(count);

        new ReactorNettyWebSocketClient().execute(uri(),
                httpHeaders(),
                session -> session.send(input.map(session::textMessage))
                        .thenMany(session.receive().take(count).map(WebSocketMessage::getPayloadAsText))
                        .subscribeWith(output)
                        .then())
                .block(ofSeconds(5));

        assertEquals(pings.collectList().block(), output.collectList().block());
        verify(messageRouter).handle("test");
        verify(messageRouter).handle("action");
    }

    private HttpHeaders httpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + AuthTestUtils.token());
        return httpHeaders;
    }

    protected URI uri() throws URISyntaxException {
        return new URI("ws://localhost:" + this.port + "/communication");
    }
}