package community.game.security;

import community.game.communication.AuthTestUtils;
import io.netty.handler.codec.http.websocketx.WebSocketHandshakeException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.reactive.socket.WebSocketSession;
import org.springframework.web.reactive.socket.client.ReactorNettyWebSocketClient;

import java.net.URI;
import java.net.URISyntaxException;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@TestPropertySource(properties = "security.enabled=true")
class SecurityIT {
    @LocalServerPort
    private String port;

    @Test
    public void canConnectWithValidToken() {
        assertDoesNotThrow(() -> {
            new ReactorNettyWebSocketClient().execute(uri(),
                    httpHeaders(AuthTestUtils.token()),
                    WebSocketSession::close)
                    .block(ofSeconds(5));
        });
    }

    @Test
    public void cantConnectWithInvalidToken() {
        assertThrows(WebSocketHandshakeException.class, () -> {
            new ReactorNettyWebSocketClient().execute(uri(),
                    httpHeaders("token"),
                    WebSocketSession::close)
                    .block(ofSeconds(5));
        });
    }

    private HttpHeaders httpHeaders(String token) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
        return httpHeaders;
    }

    protected URI uri() throws URISyntaxException {
        return new URI("ws://localhost:" + this.port + "/communication");
    }
}