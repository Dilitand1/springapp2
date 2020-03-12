import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {

    String filename;
    File file;

    public FileEventLogger(String filename) {
        this.filename = filename;
    }

    public void logEvent(Event event) {

        try {
            FileUtils.writeStringToFile(new File(filename),event.toString(),true);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException{
        System.out.println("init");
        File file = new File(filename);
        if (!file.canRead()){
            throw new IOException();
        }
    }
}
