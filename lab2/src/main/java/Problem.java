import java.util.Arrays;

public class Problem {
    private Depot[] depots;

    private Client[] clients;

    public Problem() {}

    public Problem(Depot[] depots, Client[] clients) {
        this.depots = depots;
        this.clients = clients;
    }

    public Depot[] getDepots() {
        return depots;
    }

    public void setDepots(Depot... depots) {
        this.depots = depots;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client... clients) {
        this.clients = clients;
    }

    @Override
        public String toString() {
        return "Problem{" +
                "depots=" + Arrays.toString(depots) +
                ", clients=" + Arrays.toString(clients) +
                '}';
    }

    public void getDepotsName(){
        System.out.print("Depots: ");
        for(Depot depot: depots){
            System.out.print(depot.getName() + " ");
        }
    }
}
