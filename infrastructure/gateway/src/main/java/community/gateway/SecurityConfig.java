package community.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;

@Configuration
public class SecurityConfig {
    private final SendMessageAuthenticationSuccessHandler sendMessageAuthenticationSuccessHandler;

    public SecurityConfig(SendMessageAuthenticationSuccessHandler sendMessageAuthenticationSuccessHandler) {
        this.sendMessageAuthenticationSuccessHandler = sendMessageAuthenticationSuccessHandler;
    }

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http.authorizeExchange().anyExchange().authenticated().and().logout().logoutSuccessHandler((webFilterExchange, authentication) -> Mono.empty());
        http.oauth2Login().authenticationSuccessHandler(sendMessageAuthenticationSuccessHandler);
        http.oauth2Client();
        return http.build();
    }

}
