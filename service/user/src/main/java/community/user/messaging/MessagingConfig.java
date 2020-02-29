package community.user.messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collection;

@Configuration
class MessagingConfig {
    private final String queue = "user";
    private final Collection<MessageHandler> handlers;

    MessagingConfig(Collection<MessageHandler> handlers) {
        this.handlers = handlers;
    }

    @Bean
    Queue queue() {
        return new Queue(queue, false);
    }

    @Bean
    Binding binding(Queue queue) {
        return BindingBuilder.bind(queue).to(new TopicExchange("authenticated")).with("gateway.authentication.#");
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queue);
        container.setMessageListener(getMessageListener());
        return container;
    }

    private MessageListener getMessageListener() {
        return m -> {
            String body = new String(m.getBody());
            handlers.stream().filter(h -> h.canHandle(m.getMessageProperties()))
                    .forEach(h -> h.handle(body));
        };
    }
}
