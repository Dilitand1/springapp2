import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CombinedEventLogger implements EventLogger {

    List<EventLogger> loggers;

    public CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    public void logEvent(Event event) {
        for(EventLogger eventLogger : loggers){
            eventLogger.logEvent(event);
        }

    }
}
