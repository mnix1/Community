package community.gateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.session.ReactiveSessionRepository;
import org.springframework.session.Session;
import org.springframework.session.data.redis.ReactiveRedisSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.server.RedisWebSessionConfiguration;
import reactor.core.publisher.Mono;

@Configuration
public class SessionConfiguration extends RedisWebSessionConfiguration {

    @Bean
    @Primary
    public ReactiveSessionRepository sessionRepository2() {
        ReactiveRedisSessionRepository repository = super.sessionRepository();
        return new ReactiveRedisSessionRepositoryWithMessage(repository);
    }

    private static class ReactiveRedisSessionRepositoryWithMessage extends ReactiveRedisSessionRepository {
        public ReactiveRedisSessionRepositoryWithMessage(ReactiveRedisSessionRepository repository) {
            super(repository.getSessionRedisOperations());
        }

        @Override
        public Mono createSession() {
            return super.createSession();
        }

        @Override
        public Mono findById(String id) {
            return super.findById(id);
        }

        @Override
        public Mono<Void> deleteById(String id) {
            return super.deleteById(id);
        }
    }

}
