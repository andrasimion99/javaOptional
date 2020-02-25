public class Client {
    private String name;

    private int order;

    public Client() {}

    public Client(String name, int order) {
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
