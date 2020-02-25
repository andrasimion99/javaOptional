public class Vehicle {
    private String name;
    private VehicleType type;
    private Depot depot;

    public Vehicle() {}

    public Vehicle(String name, VehicleType type, Depot depot) {
        this.name = name;
        this.type = type;
        this.depot = depot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", depot=" + depot +
                '}';
    }
}
