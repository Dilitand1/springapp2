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
        //String message = msg.replaceAll(String.valueOf(client.getId()),client.getFullname());
        //eventLogger.logEvent();
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        App app = context.getBean("app",App.class);

        /*
        App app = new App();

        app.client = new Client(1,"Jon");
        app.eventLogger = new ConsoleEventLogger();

        app.logEvent("Event for user 1");

         */
    }


}
