import java.util.Objects;

public abstract class Vehicle {

    protected String name;

    protected Depot depot;

    public Vehicle() {
    }

    abstract String getName();

    abstract void setName(String name);

    abstract Depot getDepot();

    abstract void setDepot(Depot depot);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(getName(), vehicle.getName()) &&
                Objects.equals(getDepot(), vehicle.getDepot());
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", depot=" + depot +
                '}';
    }
}
