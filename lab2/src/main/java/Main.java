import java.util.Arrays;

public class Main {
    public static void main(String args[]) {
        Problem pb = new Problem();
        Client c1 = new Client();
        c1.setName("C1");
        c1.setOrder(1);
        Client c2 = new Client("C2", 1);
        Client c3 = new Client("C3", 2);
        Client c4 = new Client("C4", 2);
        Client c5 = new Client("C5", 3);

        Depot d1 = new Depot();
        d1.setName("D1");
        Depot d2 = new Depot();
        d2.setName("D2");

        Vehicle[] vehicles = new Vehicle[2];
        vehicles[0] = new Car();
        vehicles[0].setName("V1");
        vehicles[0].setDepot(d1);
        vehicles[1] = new Car("V2", d1);
        d1.setVehicles(vehicles[0], vehicles[1]);
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }

        pb.setClients(c1, c2, c3, c4, c5);
        pb.setDepots(d1, d2);
        pb.getVehicles();

//        System.out.println(Arrays.toString(pb.getClients()));
//        pb.getDepotsName();
    }
}
