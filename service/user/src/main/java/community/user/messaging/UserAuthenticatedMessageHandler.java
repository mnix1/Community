package community.user.messaging;

import community.user.User;
import community.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
class UserAuthenticatedMessageHandler implements MessageHandler<UserAuthenticatedMessageHandler.UserAuthenticated> {
    private static final Logger logger = LoggerFactory.getLogger(UserAuthenticatedMessageHandler.class);
    private final UserService userService;

    UserAuthenticatedMessageHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean canHandle(MessageProperties properties) {
        return properties.getReceivedExchange().equals("authenticated");
    }

    @Override
    public void handle(String body) {
        logger.info("Handled message=" + body);
        UserAuthenticated userAuthenticated = MessageHandler.deserialize(UserAuthenticated.class, body);
        userService.save(userAuthenticated.toUser());
    }

    static class UserAuthenticated {
        private String subject;
        private Instant issuedAt;

        UserAuthenticated(String subject, Instant issuedAt) {
            this.subject = subject;
            this.issuedAt = issuedAt;
        }

        User toUser() {
            return new User(subject, issuedAt);
        }
    }
}
