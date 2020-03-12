import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private Map<EventType,EventLogger> map;

    App(Client client, @Qualifier("cacheLogger") EventLogger eventLogger, Map<EventType, EventLogger> map){
        this.client = client;
        this.eventLogger = eventLogger;
        this.map = map;
    }

    void logEvent(EventType eventType, Event event){
        EventLogger logger = map.get(eventType);
        if (logger == null){
            logger = eventLogger;
        }
        logger.logEvent(event);
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        App app = context.getBean("app",App.class);

        Event event1 = context.getBean("event",Event.class);
        Event event2 = context.getBean("event",Event.class);
        Event event3 = context.getBean("event",Event.class);

        app.logEvent(EventType.ERROR,event1);
        app.logEvent(EventType.INFO,event2);


        System.out.println(app.client);

        context.close();

    }


}
