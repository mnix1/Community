package community.gateway;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class MessagingConfig {
    public static final String AUTHENTICATED_TOPIC_EXCHANGE = "authenticated";
    @Bean
    TopicExchange exchange() {
        return new TopicExchange(AUTHENTICATED_TOPIC_EXCHANGE);
    }
}
