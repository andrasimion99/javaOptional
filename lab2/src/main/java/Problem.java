import java.util.Arrays;

public class Problem {
    private Depot[] depots;
    private Client[] clients;
    private Vehicle[] vehicles;
    private int numberVehicles;
    private int numberClients;

    public Problem() {
        numberVehicles = 0;
        numberClients = 0;
    }

    public Problem(Depot[] depots, Client[] clients) {
        this.depots = depots;
        this.clients = clients;
    }

    /**
     *
     * @return numarul total de clienti din problema
     */
    public int getNumberClients() {
        return numberClients;
    }

    /**
     *
     * @return numarul total de vehicule din problema
     */
    public int getNumberVehicles() {
        int number = 0;
        for (Depot depot : depots) {
            number += depot.getNumberVehicles();
        }
        return number;
    }

    public Depot[] getDepots() {
        return depots;
    }

    /**
     * se verifica introducerea in mod unica a depourilor
     * @param depots depourile respective problemei
     */
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

    /**
     * se verifica sa se introduca clientii in mod unic
     * @param clients clientii care se adauga la problema
     */
    public void setClients(Client... clients) {
        boolean ok = true;
        numberClients = clients.length;
        for (int i = 0; i < clients.length; i++) {
            if (ok) {
                for (int j = 0; j < clients.length; j++) {
                    if (clients[i].equals(clients[j]) && i != j) {
                        System.out.println("Nu putem adauga acelasi client de doua ori");
                        System.out.println("Eoare pentru clientii: " + clients[i] + "," + clients[j]);
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

    /**
     *
     * @param vehicles array-ul de vehicule in care se adauga
     * @param vehicle vehiculul care trebuie adaugat in array
     * @param index pozitia pe care se adauga
     */
    public void addVehicle(Vehicle[] vehicles, Vehicle vehicle, int index) {
        vehicles[index] = vehicle;
    }

    /**
     *
     * @return un array cu toate vehiculele din toate depourile
     */
    public Vehicle[] getVehicles() {
        vehicles = new Vehicle[getNumberVehicles()];
        int index = 0;
        for (Depot depot : depots) {
            for (int i = 0; i < depot.getNumberVehicles(); i++) {
                addVehicle(vehicles, depot.getVehicles()[i], index);
                index++;
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
}
