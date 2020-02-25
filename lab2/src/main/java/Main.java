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

        Vehicle v1 = new Vehicle();
        v1.setName("V1");
        v1.setDepot(d1);
        Vehicle v2 = new Vehicle();
        v2.setName("V2");
        v2.setDepot(d1);
        Vehicle v3 = new Vehicle();
        v3.setName("V3");
        v3.setDepot(d2);

        d1.setVehicles(v1, v2);
        d2.setVehicles(v3);

        pb.setClients(c1,c2,c3,c4,c5);
        pb.setDepots(d1,d2);

        System.out.println(Arrays.toString(pb.getClients()));
        pb.getDepotsName();
    }
}
