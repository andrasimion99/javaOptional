import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    private Problem pb;
    private Tour[] tours;

    public Solution(Problem pb) {
        this.pb = pb;
    }

    public Tour[] getTours() {
        return tours;
    }

    public void setTours(Tour[] tours) {
        this.tours = tours;
    }

    public void swap(Client c1, Client c2) {
        int aux = c1.getOrder();
        c1.setOrder(c2.getOrder());
        c2.setOrder(aux);

        String aux1 = c1.getName();
        c1.setName(c2.getName());
        c2.setName(aux1);
    }

    public void sortClients() {
        for (int i = 0; i < pb.getNumberClients(); i++) {
            for (int j = i + 1; j < pb.getNumberClients(); j++) {
                int order1 = pb.getClients()[i].getOrder();
                int order2 = pb.getClients()[j].getOrder();
                if (order1 > order2) {
                    swap(pb.getClients()[i], pb.getClients()[j]);
                }
            }
        }
    }

    public Integer[] setOrders(Client[] clients) {
        Integer[] orders = new Integer[pb.getNumberClients()];
        for (int i = 0; i < pb.getNumberClients(); i++) {
            orders[i] = pb.getClients()[i].getOrder();
        }
        return orders;
    }

    public void addClient(Client client, Client[] clients, int index) {
        clients[index] = client;
    }

    public void createTour() {
        int numberVehicles = pb.getNumberVehicles();
        int k = 0;
        tours = new Tour[numberVehicles];
        for (Depot depot : pb.getDepots()) {
            for (int i = 0; i < depot.getNumberVehicles(); i++) {
                tours[k] = new Tour();
                tours[k].setVehicle(depot.getVehicles()[i]);
                Client[] clients = new Client[pb.getNumberClients()];
                int number = 0;
                sortClients();
                ArrayList orders = new ArrayList(pb.getNumberClients());
                for (int j = 0; j < pb.getNumberClients(); j++) {
                    if (orders.indexOf(pb.getClients()[j].getOrder()) == -1 && !pb.getClients()[j].isChecked()) {
                        orders.add(pb.getClients()[j].getOrder());
                        addClient(pb.getClients()[j], clients, number);
                        number++;
                        pb.getClients()[j].setChecked(true);
                    }
                }
                tours[k].setClients(clients);
                k++;
            }
        }
    }

    @Override
    public String toString() {
        return "Solution{" +
                "tours=" + Arrays.toString(tours) +
                '}';
    }

    public void afisare() {
        for (Tour tour : tours) {
            System.out.print(tour.getVehicle().getName() + ": " + tour.getVehicle().getDepot().getName() + " -> ");
            for (Client client : tour.getClients()) {
                if (client != null) {
                    System.out.print(client.getName() + " -> ");
                }
            }
            System.out.println(tour.getVehicle().getDepot().getName() + ";");
        }
    }
}
