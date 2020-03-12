import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    int id = Math.abs(new Random().nextInt());
    String msg;
    Date date;
    DateFormat dateFormat;

    public Event(Date date, DateFormat dateFormat) {
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "id = " + id + " msg = " + msg + " date = " + dateFormat.format(date) + "\n";
    }
}
