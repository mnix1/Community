package community.game;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
class SecurityConfig {
    @Bean
    @ConditionalOnProperty(value = "security.enabled", havingValue = "true", matchIfMissing = true)
    public SecurityWebFilterChain securityEnabled(ServerHttpSecurity http) {
        http.authorizeExchange().anyExchange().authenticated().and().oauth2ResourceServer().jwt();
        return http.build();
    }

    @Bean
    @ConditionalOnProperty(value = "security.enabled", havingValue = "false")
    public SecurityWebFilterChain securityDisabled(ServerHttpSecurity http) {
        http.authorizeExchange().anyExchange().permitAll();
        return http.build();
    }
}