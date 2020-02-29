package community.user.messaging;

import com.google.gson.Gson;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.stereotype.Component;

@Component
interface MessageHandler<T> {
    static <T> T deserialize(Class<T> clazz, String body) {
        return new Gson().fromJson(body, clazz);
    }

    boolean canHandle(MessageProperties properties);

    void handle(String body);
}
