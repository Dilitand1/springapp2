public class Client {
    private int id;
    private String fullname;

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public Client(int id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }
}
