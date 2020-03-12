import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class App {
    private Client client;
    private EventLogger eventLogger;

    App(Client client,EventLogger eventLogger){
        this.client = client;
        this.eventLogger = eventLogger;
    }

    void logEvent(Event event){
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        App app = context.getBean("app",App.class);

        Event event1 = context.getBean("event",Event.class);
        Event event2 = context.getBean("event",Event.class);
        Event event3 = context.getBean("event",Event.class);

        app.logEvent(event1);
        app.logEvent(event2);
        app.logEvent(event3);

        context.close();

    }


}
