import java.util.Arrays;
import java.util.Objects;

public class Depot {
    private String name;
    private Vehicle[] vehicles;
    private int numberVehicles;

    public Depot() {
    }

    public Depot(String name, Vehicle[] vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public int getNumberVehicles() {
        return numberVehicles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicle... vehicles) {
        numberVehicles = vehicles.length;
        boolean ok = true;
        for (int i = 0; i < vehicles.length; i++) {
            vehicles[i].setDepot(this);
            if (ok) {
                for (int j = 0; j < vehicles.length; j++) {
                    if (vehicles[i].equals(vehicles[j]) && i != j) {
                        System.out.println("Nu putem adauga acelasi depou de doua ori");
                        System.out.println("Eoare pentru depourile: " + vehicles[i] + "," + vehicles[j]);
                        ok = false;
                        break;
                    }
                }
            } else {
                break;
            }

        }
        if (ok) {
            this.vehicles = vehicles;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Depot)) return false;
        Depot depot = (Depot) o;
        return Objects.equals(getName(), depot.getName()) &&
                Arrays.equals(getVehicles(), depot.getVehicles());
    }

    @Override
    public String toString() {
        String response = "Depot{" + "name='" + name + ',';
        for (Vehicle vehicle : vehicles) {
            response = response + "vehicle: " + vehicle.getName() + " ";
        }
        return response + '}';
    }
}
