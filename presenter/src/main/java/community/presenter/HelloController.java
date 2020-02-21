package community.presenter;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.jwt.Jwt;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.net.InetAddress.getLocalHost;
import static java.net.InetAddress.getLoopbackAddress;

@RestController
public class HelloController implements ApplicationContextAware {
    private static final Logger log = LoggerFactory.getLogger(HelloController.class);

    private volatile int requests = 0;
    private ApplicationContext applicationContext;
    private final RabbitTemplate rabbitTemplate;

    public HelloController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/info")
    Map<String, Object> info(
            @RequestParam(name = "shutdownChance", required = false, defaultValue = "0") int shutdownChance,
            @RequestParam(name = "sleep", required = false, defaultValue = "0") int sleep
    ) throws UnknownHostException, InterruptedException {
        Map<String, Object> response = new HashMap<>();
        Map<String, Object> host = new HashMap<>();
        host.put("localHostAddress", getLocalHost().getHostAddress());
        host.put("localHostName", getLocalHost().getHostName());
        host.put("loopbackHostAddress", getLoopbackAddress().getHostAddress());
        host.put("loopbackHostName", getLoopbackAddress().getHostName());
        response.put("host", host);
        response.put("requests", requests++);
        if (shutdownChance > 0 && new Random().nextInt(100) < shutdownChance) {
            ((ConfigurableApplicationContext) applicationContext).close();
        }
        if (sleep > 0) {
            int sleepTime = new Random().nextInt(1000);
            response.put("sleepTime", sleepTime);
            Thread.sleep(sleepTime);
        }
        rabbitTemplate.convertAndSend("api-requests", "presenter.api.info", new Gson().toJson(host));
        return response;
    }

    @GetMapping("/user")
    OidcUser user(@AuthenticationPrincipal OidcUser principal) {
        return principal;
    }

    @GetMapping("/")
    Map<String, Object> main(@AuthenticationPrincipal OidcUser principal) throws UnknownHostException, InterruptedException {
        Map<String, Object> response = info(0, 0);
        response.put("user", user(principal));
        return response;
    }

    @GetMapping("/resource")
    public String resource(@AuthenticationPrincipal Jwt jwt) {
        log.info("***** JWT Headers: {}", jwt.getHeaders());
        log.info("***** JWT Claims: {}", jwt.getClaims().toString());
        log.info("***** JWT Token: {}", jwt.getTokenValue());
        return String.format("Resource accessed by: %s (with subjectId: %s)" ,
                jwt.getClaims(),
                jwt.getSubject());
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
