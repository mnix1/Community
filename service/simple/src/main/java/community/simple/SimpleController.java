package community.simple;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static java.net.InetAddress.getLocalHost;
import static java.net.InetAddress.getLoopbackAddress;

@RestController
public class SimpleController implements ApplicationContextAware {
    private volatile int requests = 0;
    private ApplicationContext applicationContext;

    @GetMapping("/simple")
    Map<String, Object> simple() throws UnknownHostException, InterruptedException {
        Map<String, Object> response = new HashMap<>();
        response.put("localHostAddress", getLocalHost().getHostAddress());
        response.put("localHostName", getLocalHost().getHostName());
        response.put("loopbackHostAddress", getLoopbackAddress().getHostAddress());
        response.put("loopbackHostName", getLoopbackAddress().getHostName());
        response.put("requests", requests++);
        if (new Random().nextInt(100) > 70) {
            ((ConfigurableApplicationContext) applicationContext).close();
        }
        int sleepTime = new Random().nextInt(3000);
        response.put("sleepTime", sleepTime);
        Thread.sleep(sleepTime);
        return response;

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
