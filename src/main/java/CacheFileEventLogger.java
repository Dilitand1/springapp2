import java.util.ArrayList;
import java.util.List;

public class CacheFileEventLogger extends FileEventLogger {
    int cacheSize;
    public List<Event> cache;

    public CacheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
        cache = new ArrayList<Event>();
    }

    @Override
    public void logEvent(Event event) {
        cache.add(event);

        if (cache.size() > cacheSize) {
            for (Event event1 : cache) {
                super.logEvent(event1);
            }
            cache.clear();
        }
    }

    void destroy() {
        System.out.println("destroy");
        if (cache.size() > 0) {
            for (Event event1 : cache) {
                super.logEvent(event1);
            }
        }
    }

    public void setCache(List<Event> cache) {
        this.cache = cache;
    }
}
