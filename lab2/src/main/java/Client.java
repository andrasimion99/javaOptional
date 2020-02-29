import java.util.Objects;

public class Client {
    private String name;

    private int order;

    public Client() {
    }

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;
        Client client = (Client) o;
        return getOrder() == client.getOrder() &&
                Objects.equals(getName(), client.getName());
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", order=" + order +
                '}';
    }
}
