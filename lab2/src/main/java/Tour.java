import java.util.Arrays;

public class Tour {
    private Vehicle vehicle;

    private Client[] clients;

    public Tour() {}

    public Tour(Vehicle vehicle, Client[] clients) {
        this.vehicle = vehicle;
        this.clients = clients;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "vehicle=" + vehicle +
                ", clients=" + Arrays.toString(clients) +
                '}';
    }
}
