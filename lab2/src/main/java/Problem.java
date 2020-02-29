import java.util.Arrays;

public class Problem {
    private Depot[] depots;
    private Client[] clients;
    private Vehicle[] vehicles;
    private int numberVehicles;

    public Problem() {
        numberVehicles = 0;
    }

    public Problem(Depot[] depots, Client[] clients) {
        this.depots = depots;
        this.clients = clients;
    }

    public int getNumberVehicles() {
        int number = 0;
        for (Depot depot : depots) {
            number += depot.getVehicles().length;
        }
        return number;
    }

    public Depot[] getDepots() {
        return depots;
    }

    public void setDepots(Depot... depots) {
        boolean ok = true;
        for (int i = 0; i < depots.length; i++) {
            if (ok) {
                for (int j = 0; j < depots.length; j++) {
                    if (depots[i].equals(depots[j]) && i != j) {
                        System.out.println("Nu putem adauga acelasi depou de doua ori");
                        System.out.println("Eoare pentru depourile: " + depots[i] + "," + depots[j]);
                        ok = false;
                        break;
                    }
                }
            } else {
                break;
            }

        }
        if (ok) {
            this.depots = depots;
        }
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client... clients) {
        boolean ok = true;
        for (int i = 0; i < clients.length; i++) {
            if (ok) {
                for (int j = 0; j < clients.length; j++) {
                    if (clients[i].equals(clients[j]) && i != j) {
                        System.out.println("Nu putem adauga acelasi depou de doua ori");
                        System.out.println("Eoare pentru depourile: " + clients[i] + "," + clients[j]);
                        ok = false;
                        break;
                    }
                }
            } else {
                break;
            }

        }
        if (ok) {
            this.clients = clients;
        }
    }

    public Vehicle[] getVehicles() {
        vehicles = new Vehicle[getNumberVehicles()];
        for (Depot depot : depots) {
            for (int i = 0; i < depot.getVehicles().length; i++) {
                //vehicles[numberVehicles] = new <-----------------AICI E PROBLEMA
                vehicles[numberVehicles++] = depot.getVehicles()[i];

            }
        }
        return vehicles;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "depots=" + Arrays.toString(depots) +
                ", clients=" + Arrays.toString(clients) +
                '}';
    }

    public void getDepotsName() {
        System.out.print("Depots: ");
        for (Depot depot : depots) {
            System.out.print(depot.getName() + " ");
        }
    }
}
