public class Client {
    private int id;
    private String fullname;
    private String greeting;

    public int getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", greeting='" + greeting + '\'' +
                '}';
    }

    public Client(int id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }
}
