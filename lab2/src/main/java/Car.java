
public class Car extends Vehicle {
    public Car() {
    }

    public Car(String name, Depot depot) {
        this.name = name;
        this.depot = depot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Depot getDepot() {
        return depot;
    }

    public void setDepot(Depot depot) {
        this.depot = depot;
    }
}
