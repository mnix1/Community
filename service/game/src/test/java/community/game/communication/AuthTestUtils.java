package community.game.communication;

import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

public class AuthTestUtils {
    public static String token() {
        LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");
        body.add("client_id", "service");
        body.add("client_secret", "**********");
        return WebClient.create("http://host.docker.internal:4000/auth/realms/local/protocol/openid-connect/token")
                .post()
                .bodyValue(body)
                .header(CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .exchange()
                .flatMap(clientResponse -> clientResponse.bodyToMono(Map.class))
                .map(map -> map.get("access_token"))
                .cast(String.class)
                .block();
    }
}
