package community.gateway;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.RedirectServerAuthenticationSuccessHandler;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;

import static community.gateway.MessagingConfig.AUTHENTICATED_TOPIC_EXCHANGE;

@Component
class SendMessageAuthenticationSuccessHandler implements ServerAuthenticationSuccessHandler {
    private final static Logger logger = LoggerFactory.getLogger(SendMessageAuthenticationSuccessHandler.class);
    private final RedirectServerAuthenticationSuccessHandler authenticationSuccessHandler = new RedirectServerAuthenticationSuccessHandler();
    private final RabbitTemplate rabbitTemplate;

    SendMessageAuthenticationSuccessHandler(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
        logger.info("AuthenticationSuccess authentication=" + authentication);
        if (authentication.getPrincipal() instanceof OidcUser) {
            sendMessage(messageBody(authentication));
        } else {
            return Mono.error(new RuntimeException("Authentication principal is not instance of OidcUser"));
        }
        return authenticationSuccessHandler.onAuthenticationSuccess(webFilterExchange, authentication);
    }

    private void sendMessage(String messageBody) {
        rabbitTemplate.convertAndSend(AUTHENTICATED_TOPIC_EXCHANGE, "gateway.authentication", messageBody);
    }

    private String messageBody(Authentication authentication) {
        OidcUser oidcUser = (OidcUser) authentication.getPrincipal();
        Map<String, Object> message = Map.of(
                "subject", oidcUser.getSubject(),
                "issuedAt", oidcUser.getIssuedAt()
        );
        return new Gson().toJson(message);
    }
}
